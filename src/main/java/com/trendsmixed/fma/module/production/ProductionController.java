package com.trendsmixed.fma.module.production;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.log.LogExecution;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.controlpoint.ControlPointService;
import com.trendsmixed.fma.module.controlpointtype.ControlPointType;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.job.JobService;
import com.trendsmixed.fma.module.manpower.Manpower;
import com.trendsmixed.fma.module.manpower.ManpowerService;
import com.trendsmixed.fma.module.operation.Operation;
import com.trendsmixed.fma.module.operation.OperationService;
import com.trendsmixed.fma.module.operationtype.OperationType;
import com.trendsmixed.fma.module.operationtype.OperationTypeService;
import com.trendsmixed.fma.module.productionemployee.ProductionEmployee;
import com.trendsmixed.fma.module.producttype.ProductType;
import com.trendsmixed.fma.module.producttype.ProductTypeService;
import com.trendsmixed.fma.module.resourceutilization.ResourceUtilization;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.shift.Shift;
import com.trendsmixed.fma.module.shift.ShiftService;
import com.trendsmixed.fma.module.shifttype.ShiftType;
import com.trendsmixed.fma.module.shifttype.ShiftTypeService;
import com.trendsmixed.fma.utility.Format;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/productions")
public class ProductionController {

    private final ProductionService service;
    private final OperationService operationService;
    private final ManpowerService manpowerService;
    private final ControlPointService controlPointService;
    private final JobService jobService;
    private final ProductTypeService productTypeService;
    private final OperationTypeService operationTypeService;
    private final ShiftService shiftService;
    private final ShiftTypeService shiftTypeService;

    @LogExecution
    @JsonView(ProductionView.AllAndShiftAndShiftTypeAndControlPointAll.class)
    @GetMapping
    public Iterable<Production> findAll() {
        return service.findAll();
    }

    @LogExecution
    @JsonView(ProductionView.AllAndShiftAndShiftTypeAndControlPointAll.class)
    @GetMapping("/page")
    Page<Production> page(Pageable pageable) {
        return new Page(service.findAll(pageable));
    }

    @LogExecution
    @JsonView(ProductionView.AllAndShiftAllAndControlPointAndControlPointTypeAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/controlPointTypeAndSectionAndShiftAndProductionDateBetween")
    public Page<Production> getControlPointTypeAndSectionAndShiftAndProductionDateBetweenPage(
            @RequestParam(value = "controlPointType", required = false, defaultValue = "0") String controlPointType,
            @RequestParam(value = "section", required = false, defaultValue = "0") String section,
            @RequestParam(value = "shift", required = false, defaultValue = "0") String shift,
            @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
            @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate,
            Pageable pageable) throws ParseException {
        Page<Production> page;

        if (controlPointType.equals("0") && section.equals("0") && shift.equals("0")) {
            page = new Page(service.findByProductionDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } else if (controlPointType.equals("0") && section.equals("0")) {
            page = new Page(service.findByProductionDateBetweenAndShift(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Shift(Integer.valueOf(shift)), pageable));
        } else if (section.equals("0") && shift.equals("0")) {
            page = new Page(service.findByProductionDateBetweenAndControlPointControlPointType(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new ControlPointType(Integer.valueOf(controlPointType)), pageable));
        } else if (controlPointType.equals("0") && shift.equals("0")) {
            page = new Page(service.findByControlPointWorkCenterCostCenterSectionAndProductionDateBetween(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } else if (controlPointType.equals("0")) {
            page = new Page(service.findByControlPointWorkCenterCostCenterSectionAndProductionDateBetweenAndShift(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Shift(Integer.valueOf(shift)), pageable));
        } else if (section.equals("0")) {
            page = new Page(service.findByControlPointControlPointTypeAndProductionDateBetweenAndShift(new ControlPointType(Integer.valueOf(controlPointType)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Shift(Integer.valueOf(shift)), pageable));
        } else if (shift.equals("0")) {
            page = new Page(service.findByControlPointControlPointTypeAndProductionDateBetweenAndControlPointWorkCenterCostCenterSection(new ControlPointType(Integer.valueOf(controlPointType)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Section(Integer.valueOf(section)), pageable));
        } else {
            page = new Page(service.findByControlPointWorkCenterCostCenterSectionAndShiftAndProductionDateBetweenAndControlPointControlPointType(new Section(Integer.valueOf(section)), new Shift(Integer.valueOf(shift)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new ControlPointType(Integer.valueOf(controlPointType)), pageable));
        }
        return page;
    }

    @LogExecution
    @JsonView(ProductionView.All.class)
    @PostMapping
    public Production save(@RequestBody Production production,
                           @RequestHeader(value = "email", defaultValue = "") String email) {
        // 
        try {
            List<Operation> operations = production.getOperationList();
            List<Manpower> manpowers = production.getManpowerList();
            List<ProductionEmployee> productionEmployeeList = production.getProductionEmployeeList();
//
//            if (production.getId() != null && production.getId() > 0) {
//                List<Operation> oldOperations = operationService.findByProduction(new Production(production.getId()));
//                outerloop:
//                for (Operation oldOperation : oldOperations) {
//                    for (Operation operation : operations) {
//                        if (operation.getId() != null && operation.getId() == oldOperation.getId()) {
//                            continue outerloop;
//                        }
//                    }
//                    operationService.delete(oldOperation.getId());
//                }
//
//                List<Manpower> oldManpowers = manpowerService.findByProduction(new Production(production.getId()));
//                outerloop:
//                for (Manpower oldManpower : oldManpowers) {
//                    for (Manpower manpower : manpowers) {
//                        if (manpower.getId() != null && manpower.getId() == oldManpower.getId()) {
//                            continue outerloop;
//                        }
//                    }
//                    manpowerService.delete(oldManpower.getId());
//                }
//            }

//                    for (Manpower manpower : manpowers) {
//                        manpower.setProduction(new Production(production.getId()));
//                    }
//                    manpowerService.save(manpowers);
//                    for (Operation operation : operations) {
//                        operation.setProduction(new Production(production.getId()));
//                    }
//                    operationService.save(operations);
//                    
//            production = service.save(production);
//            } else {
            if (operations != null) {
                for (Operation operation : operations) {
                    operation.setProduction(production);
                }
            }
            if (manpowers != null) {
                for (Manpower manpower : manpowers) {
                    manpower.setProduction(production);
                }
            }
            if (productionEmployeeList != null) {
                for (ProductionEmployee productionEmployee : productionEmployeeList) {
                    productionEmployee.setProduction(production);
                }
            }

            List<ResourceUtilization> resourceUtilizations = production.getResourceUtilizationList();

            if (resourceUtilizations != null) {
                for (ResourceUtilization resourceUtilization : resourceUtilizations) {
                    resourceUtilization.setProduction(production);
                }
            }

            production = service.save(production);

            return production;

        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @LogExecution
    @JsonView(ProductionView.AllAndShiftAllAndControlPointAndControlPointTypeAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @PostMapping("/ByProductionDateAndShiftAndControlPoint")
    public Production ByProductionDateAndShiftAndControlPoint(@RequestBody Production production,
                                                              @RequestHeader(value = "email", defaultValue = "") String email) {


        return service.findByProductionDateAndShiftAndControlPoint(production.getProductionDate(),
                production.getShift(), production.getControlPoint());
    }

    @LogExecution
    @PostMapping("/many")
    public void saveMany(@RequestBody List<Production> productions,
                         @RequestHeader(value = "email", defaultValue = "") String email) {

        try {
            productions.forEach(production -> {
                ControlPoint controlPoint = production.getControlPoint();
                if (controlPoint.getId() == null && controlPoint.getCode() != null) {
                    production.setControlPoint(controlPointService.findByCode(controlPoint.getCode()));
                }

                Shift shift = production.getShift();
                if (shift.getId() == null && shift.getCode() != null) {
                    production.setShift(shiftService.findByCode(shift.getCode()));
                }
                ShiftType shiftType = production.getShiftType();
                if (shiftType.getId() == null && shiftType.getCode() != null) {
                    production.setShiftType(shiftTypeService.findByCode(shiftType.getCode()));
                }

                List<Operation> operations = production.getOperationList();
                List<Manpower> manpowers = production.getManpowerList();
                List<ProductionEmployee> productionEmployeeList = production.getProductionEmployeeList();
                if (operations != null) {
                    for (Operation operation : operations) {
                        operation.setProduction(production);
                        Job job = operation.getJob();
                        if (job.getId() == null && job.getJobNo() != null) {
                            operation.setJob(jobService.findByJobNo(job.getJobNo()));
                        }
                        ProductType productType = operation.getProductType();
                        if (productType.getId() == null && productType.getCode() != null) {
                            operation.setProductType(productTypeService.findByCode(productType.getCode()));
                        }
                        OperationType operationType = operation.getOperationType();
                        if (operationType.getId() == null && operationType.getCode() != null) {
                            operation.setOperationType(operationTypeService.findByCode(operationType.getCode()));
                        }
                    }
                }
                if (manpowers != null) {
                    for (Manpower manpower : manpowers) {
                        manpower.setProduction(production);
                    }
                }
                if (productionEmployeeList != null) {
                    for (ProductionEmployee productionEmployee : productionEmployeeList) {
                        productionEmployee.setProduction(production);
                    }
                }

                List<ResourceUtilization> resourceUtilizations = production.getResourceUtilizationList();

                if (resourceUtilizations != null) {
                    for (ResourceUtilization resourceUtilization : resourceUtilizations) {
                        resourceUtilization.setProduction(production);
                    }
                }
            });
            service.save(productions);

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @LogExecution
    @JsonView(ProductionView.AllShiftAllShiftTypeAllControlPointAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAllProductionEmployeeAllEmployeeAllResourceUtilizationAllMachineAllEmployeeAll.class)
    @GetMapping("/{id}")
    public Production findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
                       HttpServletRequest request) {

        service.deleteById(id);
    }

    @LogExecution
    @PutMapping("/{id}")
    public Production updateCustomer(@PathVariable int id, @RequestBody Production production,
                                     @RequestHeader(value = "email", defaultValue = "") String email) {

        production.setId(id);
        production = service.save(production);
        return production;
    }

}
