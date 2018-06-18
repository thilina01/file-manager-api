package com.trendsmixed.fma.module.production;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.controlpointtype.ControlPointType;
import com.trendsmixed.fma.module.manpower.Manpower;
import com.trendsmixed.fma.module.manpower.ManpowerService;
import com.trendsmixed.fma.module.operation.Operation;
import com.trendsmixed.fma.module.operation.OperationService;
import com.trendsmixed.fma.module.productionemployee.ProductionEmployee;
import com.trendsmixed.fma.module.resourceutilization.ResourceUtilization;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.shift.Shift;
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

    @JsonView(ProductionView.AllAndShiftAndShiftTypeAndControlPointAll.class)
    @GetMapping
    public Iterable<Production> findAll() {
        return service.findAll();
    }

    @JsonView(ProductionView.AllAndShiftAndShiftTypeAndControlPointAll.class)
    @GetMapping("/page")
    Page<Production> page(Pageable pageable) {
        return new Page(service.findAll(pageable));
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAndControlPointTypeAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/sectionAndProductionDateAndShiftPage", params = {"section", "productionDate", "shift"})
    public Page<Production> sectionAndProductionDateAndShiftPage(@RequestParam("section") String section, @RequestParam("productionDate") String productionDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByControlPointWorkCenterCostCenterSectionAndProductionDateAndShift(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(productionDate), new Shift(Integer.valueOf(shift)), pageable));
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAndControlPointTypeAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/sectionAndProductionDurationAndShiftPage", params = {"section", "startDate", "endDate", "shift"})
    public Page<Production> sectionAndProductionDurationAndShiftPage(@RequestParam("section") String section, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByControlPointWorkCenterCostCenterSectionAndProductionDateBetweenAndShift(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Shift(Integer.valueOf(shift)), pageable));
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAndControlPointTypeAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/sectionAndProductionDurationPage", params = {"section", "startDate", "endDate"})
    public Page<Production> sectionAndProductionDurationPage(@RequestParam("section") String section, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByControlPointWorkCenterCostCenterSectionAndProductionDateBetween(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAndControlPointTypeAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/productionDateAndShiftPage", params = {"productionDate", "shift"})
    public Page<Production> productionDateAndShiftPage(@RequestParam("productionDate") String productionDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionDateAndShift(Format.yyyy_MM_dd.parse(productionDate), new Shift(Integer.valueOf(shift)), pageable));
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAndControlPointTypeAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/productionDurationAndShiftPage", params = {"startDate", "endDate", "shift"})
    public Page<Production> productionDurationAndShiftPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionDateBetweenAndShift(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Shift(Integer.valueOf(shift)), pageable));
    }
    @JsonView(ProductionView.AllAndShiftAllAndControlPointAndControlPointTypeAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/productionDurationPage", params = {"startDate", "endDate"})
    public Page<Production> productionDurationPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAndControlPointTypeAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/sectionAndShiftAndProductionDurationAndControlPointTypePage", params = {"section","shift", "startDate", "endDate", "controlPointType"})
    public Page<Production> sectionAndShiftAndProductionDurationAndControlPointTypePage(@RequestParam("section") String section,@RequestParam("shift") String shift, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,  @RequestParam("controlPointType") String controlPointType, Pageable pageable) throws ParseException {
        return new Page(service.findByControlPointWorkCenterCostCenterSectionAndShiftAndProductionDateBetweenAndControlPointControlPointType(new Section(Integer.valueOf(section)),new Shift(Integer.valueOf(shift)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),  new ControlPointType(Integer.valueOf(controlPointType)), pageable));
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAndControlPointTypeAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/sectionAndShiftAndProductionDateAndControlPointTypePage", params = {"section", "productionDate", "controlPointType", "shift"})
    public Page<Production> sectionAndShiftAndProductionDateAndControlPointTypePage(@RequestParam("section") String section, @RequestParam("productionDate") String productionDate, @RequestParam("controlPointType") String controlPointType, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByControlPointWorkCenterCostCenterSectionAndShiftAndProductionDateAndControlPointControlPointType(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(productionDate), new ControlPointType(Integer.valueOf(controlPointType)), new Shift(Integer.valueOf(shift)), pageable));
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAndControlPointTypeAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/productionDateAndControlPointTypePage", params = {"productionDate", "controlPointType"})
    public Page<Production> productionDateAndControlPointTypePage(@RequestParam("productionDate") String productionDate, @RequestParam("controlPointType") String controlPointType, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionDateAndControlPointControlPointType(Format.yyyy_MM_dd.parse(productionDate), new ControlPointType(Integer.valueOf(controlPointType)), pageable));
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAndControlPointTypeAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/productionDurationAndControlPointTypePage", params = {"startDate", "endDate", "controlPointType"})
    public Page<Production> productionDurationAndControlPointTypePage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("controlPointType") String controlPointType, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionDateBetweenAndControlPointControlPointType(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new ControlPointType(Integer.valueOf(controlPointType)), pageable));
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAndControlPointTypeAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/controlPointTypeAndProductionDateAndShiftPage", params = {"controlPointType", "productionDate", "shift"})
    public Page<Production> controlPointTypeAndProductionDateAndShiftPage(@RequestParam("controlPointType") String controlPointType, @RequestParam("productionDate") String productionDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByControlPointControlPointTypeAndProductionDateAndShift(new ControlPointType(Integer.valueOf(controlPointType)), Format.yyyy_MM_dd.parse(productionDate), new Shift(Integer.valueOf(shift)), pageable));
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAndControlPointTypeAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/controlPointTypeAndProductionDurationAndShiftPage", params = {"controlPointType", "startDate", "endDate", "shift"})
    public Page<Production> controlPointTypeAndProductionDurationAndShiftPage(@RequestParam("controlPointType") String controlPointType, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByControlPointControlPointTypeAndProductionDateBetweenAndShift(new ControlPointType(Integer.valueOf(controlPointType)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Shift(Integer.valueOf(shift)), pageable));
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAndControlPointTypeAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/controlPointTypeAndProductionDateAndSectionPage", params = {"controlPointType", "productionDate", "section"})
    public Page<Production> controlPointTypeAndProductionDateAndSectionPage(@RequestParam("controlPointType") String controlPointType, @RequestParam("productionDate") String productionDate, @RequestParam("section") String section, Pageable pageable) throws ParseException {
        return new Page(service.findByControlPointControlPointTypeAndProductionDateAndControlPointWorkCenterCostCenterSection(new ControlPointType(Integer.valueOf(controlPointType)), Format.yyyy_MM_dd.parse(productionDate), new Section(Integer.valueOf(section)), pageable));
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAndControlPointTypeAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/controlPointTypeAndProductionDurationAndSectionPage", params = {"controlPointType", "startDate", "endDate", "section"})
    public Page<Production> controlPointTypeAndProductionDurationAndSectionPage(@RequestParam("controlPointType") String controlPointType, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("section") String section, Pageable pageable) throws ParseException {
        return new Page(service.findByControlPointControlPointTypeAndProductionDateBetweenAndControlPointWorkCenterCostCenterSection(new ControlPointType(Integer.valueOf(controlPointType)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Section(Integer.valueOf(section)), pageable));
    }

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

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAndControlPointTypeAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @PostMapping("/ByProductionDateAndShiftAndControlPoint")
    public Production ByProductionDateAndShiftAndControlPoint(@RequestBody Production production,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        

        return service.findByProductionDateAndShiftAndControlPoint(production.getProductionDate(),
                production.getShift(), production.getControlPoint());
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Production> productions,
            @RequestHeader(value = "email", defaultValue = "") String email) {

        
        try {
            service.save(productions);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ProductionView.AllShiftAllShiftTypeAllControlPointAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAllProductionEmployeeAllEmployeeAllResourceUtilizationAllMachineAllEmployeeAll.class)
    @GetMapping("/{id}")
    public Production findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.delete(id);
    }

    @PutMapping("/{id}")
    public Production updateCustomer(@PathVariable int id, @RequestBody Production production,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        production.setId(id);
        production = service.save(production);
        return production;
    }

}
