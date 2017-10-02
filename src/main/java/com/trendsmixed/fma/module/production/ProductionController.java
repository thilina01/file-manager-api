package com.trendsmixed.fma.module.production;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.manpower.Manpower;
import com.trendsmixed.fma.module.operation.Operation;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.manpower.ManpowerService;
import com.trendsmixed.fma.module.operation.OperationService;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.shift.Shift;
import com.trendsmixed.fma.utility.Format;
import com.trendsmixed.fma.utility.Page;
import java.text.ParseException;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
@RequestMapping("/productions")
public class ProductionController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ProductionService service;
    @Autowired
    private OperationService operationService;
    @Autowired
    private ManpowerService manpowerService;

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

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/sectionAndProductionDateAndShiftPage", params = {"section", "productionDate", "shift"})
    public Page<Operation> sectionAndProductionDateAndShiftPage(@RequestParam("section") String section, @RequestParam("productionDate") String productionDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByControlPointWorkCenterCostCenterSectionAndProductionDateAndShift(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(productionDate), new Shift(Integer.valueOf(shift)), pageable));
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/sectionAndProductionDurationAndShiftPage", params = {"section", "startDate", "endDate", "shift"})
    public Page<Operation> sectionAndProductionDurationAndShiftPage(@RequestParam("section") String section, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByControlPointWorkCenterCostCenterSectionAndProductionDateBetweenAndShift(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Shift(Integer.valueOf(shift)), pageable));
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/sectionAndProductionDurationPage", params = {"section", "startDate", "endDate"})
    public Page<Operation> sectionAndProductionDurationPage(@RequestParam("section") String section, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByControlPointWorkCenterCostCenterSectionAndProductionDateBetween(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/productionDateAndShiftPage", params = {"productionDate", "shift"})
    public Page<Operation> productionDateAndShiftPage(@RequestParam("productionDate") String productionDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionDateAndShift(Format.yyyy_MM_dd.parse(productionDate), new Shift(Integer.valueOf(shift)), pageable));
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/productionDurationAndShiftPage", params = {"startDate", "endDate", "shift"})
    public Page<Operation> productionDurationAndShiftPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionDateBetweenAndShift(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Shift(Integer.valueOf(shift)), pageable));
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping(value = "/productionDurationPage", params = {"startDate", "endDate"})
    public Page<Operation> productionDurationPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @JsonView(ProductionView.All.class)
    @PostMapping
    public Production save(@RequestBody Production production,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        // appSessionService.isValid(email, request);
        try {
            List<Operation> operations = production.getOperationList();
            List<Manpower> manpowers = production.getManpowerList();
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

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @PostMapping("/ByProductionDateAndShiftAndControlPoint")
    public Production ByProductionDateAndShiftAndControlPoint(@RequestBody Production production,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);

        return service.findByProductionDateAndShiftAndControlPoint(production.getProductionDate(),
                production.getShift(), production.getControlPoint());
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Production> productions,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(productions);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ProductionView.AllAndShiftAllAndControlPointAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
    @GetMapping("/{id}")
    public Production findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @PutMapping("/{id}")
    public Production updateCustomer(@PathVariable int id, @RequestBody Production production,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        production.setId(id);
        production = service.save(production);
        return production;
    }

}
