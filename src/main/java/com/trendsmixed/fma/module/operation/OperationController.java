package com.trendsmixed.fma.module.operation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.trendsmixed.fma.entity.Operation;
import com.trendsmixed.fma.entity.Section;
import com.trendsmixed.fma.entity.Shift;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Format;
import com.trendsmixed.fma.utility.Page;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
@RequestMapping("/operations")
public class OperationController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private OperationService service;

    @JsonView(OperationView.AllJobAllProductionAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll.class)
    @GetMapping
    public Iterable<Operation> findAll() {
        return service.findAll();
    }

    @JsonView(OperationView.AllJobAllJobTypeAllItemAllProductionAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll.class)
    @GetMapping("/page")
    public Page<Operation> page(Pageable pageable) {
        return new Page(service.findAll(pageable));
    }

    @JsonView(OperationView.AllJobAllJobTypeAllItemAllProductionAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll.class)
    @GetMapping(value = "/sectionAndProductionDateAndShiftPage", params = {"section", "productionDate", "shift"})
    public Page<Operation> sectionAndProductionDateAndShiftPage(@RequestParam("section") String section, @RequestParam("productionDate") String productionDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        System.out.println(section + " / " + productionDate + " / " + shift);
        System.out.println(pageable);
        
        return new Page(service.findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateAndProductionShift(new Section(Integer.valueOf(section)),Format.yyyy_MM_dd.parse(productionDate), new Shift(Integer.valueOf(shift)),pageable));
        //return service.findAll(pageable);
    }

    @JsonView(OperationView.AllJobAllJobTypeAllItemAllProductionAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll.class)
    @GetMapping(value = "/productionDateAndShiftPage", params = {"productionDate", "shift"})
    public Page<Operation> productionDateAndShiftPage(@RequestParam("productionDate") String productionDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {

        return new Page(service.findByProductionProductionDateAndProductionShift(Format.yyyy_MM_dd.parse(productionDate), new Shift(Integer.valueOf(shift)),pageable));
        //return service.findAll(pageable);
    }

    @JsonView(OperationView.All.class)
    @PostMapping
    public Operation save(@RequestBody Operation operation,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            operation = service.save(operation);
            return operation;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Operation> operations,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(operations);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(OperationView.AllJobAllProductionAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll.class)
    @GetMapping("/{id}")
    public Operation findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public Operation updateCustomer(@PathVariable int id, @RequestBody Operation operation,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        operation.setId(id);
        operation = service.save(operation);
        return operation;
    }

    @GetMapping("/test")
    public List test() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM");
        Date startDate = new Date(), endDate = new Date();
        try {
            startDate = sdf.parse("2017-02-01 00:00");
            endDate = sdf.parse("2017-02-28 23:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return service.test(startDate, endDate);
    }
}
