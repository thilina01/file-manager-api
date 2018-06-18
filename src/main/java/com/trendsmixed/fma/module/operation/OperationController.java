package com.trendsmixed.fma.module.operation;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.OperationSummary;
import com.trendsmixed.fma.dao.view.OperationSummaryView;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.shift.Shift;
import com.trendsmixed.fma.utility.Format;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/operations")
public class OperationController {

    
    private final OperationService service;

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
        return new Page(service.findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateAndProductionShift(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(productionDate), new Shift(Integer.valueOf(shift)), pageable));
    }

    @JsonView(OperationView.AllJobAllJobTypeAllItemAllProductionAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll.class)
    @GetMapping(value = "/sectionAndProductionDurationAndShiftPage", params = {"section", "startDate", "endDate", "shift"})
    public Page<Operation> sectionAndProductionDurationAndShiftPage(@RequestParam("section") String section, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateBetweenAndProductionShift(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Shift(Integer.valueOf(shift)), pageable));
    }

    @JsonView(OperationView.AllJobAllJobTypeAllItemAllProductionAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll.class)
    @GetMapping(value = "/sectionAndProductionDurationPage", params = {"section", "startDate", "endDate"})
    public Page<Operation> sectionAndProductionDurationPage(@RequestParam("section") String section, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateBetween(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @JsonView(OperationView.AllJobAllJobTypeAllItemAllProductionAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll.class)
    @GetMapping(value = "/productionDateAndShiftPage", params = {"productionDate", "shift"})
    public Page<Operation> productionDateAndShiftPage(@RequestParam("productionDate") String productionDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionProductionDateAndProductionShift(Format.yyyy_MM_dd.parse(productionDate), new Shift(Integer.valueOf(shift)), pageable));
    }

    @JsonView(OperationView.AllJobAllJobTypeAllItemAllProductionAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll.class)
    @GetMapping(value = "/productionDurationAndShiftPage", params = {"startDate", "endDate", "shift"})
    public Page<Operation> productionDurationAndShiftPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionProductionDateBetweenAndProductionShift(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Shift(Integer.valueOf(shift)), pageable));
    }

    @JsonView(OperationView.AllJobAllJobTypeAllItemAllProductionAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll.class)
    @GetMapping(value = "/productionDurationPage", params = {"startDate", "endDate"})
    public Page<Operation> productionDurationPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionProductionDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @JsonView(OperationView.AllJobAllJobTypeAllItemAllProductionAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll.class)
    @GetMapping(value = "/jobPage", params = {"job"})
    public Page<Operation> jobPage(@RequestParam("job") String job, Pageable pageable) throws ParseException {
        return new Page(service.findByJob(new Job(Integer.valueOf(job)), pageable));
    }

    @JsonView(OperationSummaryView.All.class)
    @GetMapping(value = "/summaryByJob", params = {"jobId"})
    public List<OperationSummary> getSummaryByJob(@RequestParam("jobId") int jobId) {
        return service.getSummaryByJob(jobId);
    }

    @JsonView(OperationView.All.class)
    @PostMapping
    public Operation save(@RequestBody Operation operation,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
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
            @RequestHeader(value = "email", defaultValue = "") String email) {

        
        try {
            service.save(operations);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(OperationView.AllJobAllProductionAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAllOperationProgressAll.class)
    @GetMapping("/{id}")
    public Operation findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.delete(id);

    }

    @PutMapping("/{id}")
    public Operation updateCustomer(@PathVariable int id, @RequestBody Operation operation,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
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
