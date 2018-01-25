package com.trendsmixed.fma.module.operationprogress;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import java.text.ParseException;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.utility.Format;
import org.springframework.data.domain.Pageable;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/operationProgresses")
public class OperationProgressController {

    private final AppSessionService appSessionService;
    private final OperationProgressService service;

    @JsonView(OperationProgressView.All.class)
    @GetMapping
    public Iterable<OperationProgress> findAll() {
        return service.findAll();
    }
    @JsonView(OperationProgressView.AllAndJobAndProductTypeAllAndProductionAndOperationTypeAndControlPointAllAndOperationAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping("/page")
    Page<OperationProgress> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    @JsonView(OperationProgressView.AllAndJobAndProductTypeAllAndProductionAndOperationTypeAndControlPointAllAndOperationAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping(value = "/productionDurationPage", params = {"startDate", "endDate"})
    public Page<OperationProgress> productionDurationPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByOperationProductionProductionDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }
    @JsonView(OperationProgressView.AllAndJobAndProductTypeAllAndProductionAndOperationTypeAndControlPointAllAndOperationAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping(value = "/sectionAndProductionDurationPage", params = {"section", "startDate", "endDate"})
    public Page<OperationProgress> sectionAndProductionDurationPage(@RequestParam("section") String section, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateBetween(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }
    @JsonView(OperationProgressView.AllAndJobAndProductTypeAllAndProductionAndOperationTypeAndControlPointAllAndOperationAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping(value = "/productionDateAndControlPointPage", params = {"productionDate", "controlPoint"})
    public Page<OperationProgress> productionDateAndControlPointPage(@RequestParam("productionDate") String productionDate, @RequestParam("controlPoint") String controlPoint, Pageable pageable) throws ParseException {
        return new Page(service.findByOperationProductionProductionDateAndOperationProductionControlPoint(Format.yyyy_MM_dd.parse(productionDate), new ControlPoint(Integer.valueOf(controlPoint)), pageable));
    }
    @JsonView(OperationProgressView.AllAndJobAndProductTypeAllAndProductionAndOperationTypeAndControlPointAllAndOperationAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping(value = "/productionDurationAndControlPointPage", params = {"startDate", "endDate", "controlPoint"})
    public Page<OperationProgress> productionDurationAndControlPointPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("controlPoint") String controlPoint, Pageable pageable) throws ParseException {
        return new Page(service.findByOperationProductionProductionDateBetweenAndOperationProductionControlPoint(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new ControlPoint(Integer.valueOf(controlPoint)), pageable));
    }
    @JsonView(OperationProgressView.AllAndJobAndProductTypeAllAndProductionAndOperationTypeAndControlPointAllAndOperationAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping(value = "/productionDurationAndJobPage", params = {"startDate", "endDate", "job"})
    public Page<OperationProgress> productionDurationAndJobPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("job") String job, Pageable pageable) throws ParseException {
        return new Page(service.findByOperationProductionProductionDateBetweenAndOperationJob(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Job(Integer.valueOf(job)), pageable));
    }
    @JsonView(OperationProgressView.AllAndJobAndProductTypeAllAndProductionAndOperationTypeAndControlPointAllAndOperationAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping(value = "/productionDateAndJobPage", params = {"productionDate", "job"})
    public Page<OperationProgress> productionDateAndJobPage(@RequestParam("productionDate") String productionDate, @RequestParam("job") String job, Pageable pageable) throws ParseException {
        return new Page(service.findByOperationProductionProductionDateAndOperationJob(Format.yyyy_MM_dd.parse(productionDate), new Job(Integer.valueOf(job)), pageable));
    }
    @JsonView(OperationProgressView.AllAndJobAndProductTypeAllAndProductionAndOperationTypeAndControlPointAllAndOperationAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping(value = "/sectionAndJobAndProductionDurationAndControlPointPage", params = {"section", "startDate", "endDate", "controlPoint", "job"})
    public Page<OperationProgress> sectionAndJobAndProductionDurationAndControlPointPage(@RequestParam("section") String section, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("job") String job, @RequestParam("controlPoint") String controlPoint, Pageable pageable) throws ParseException {
        return new Page(service.findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationJobAndOperationProductionProductionDateBetweenAndOperationProductionControlPoint(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Job(Integer.valueOf(job)), new ControlPoint(Integer.valueOf(controlPoint)), pageable));
    }
    @JsonView(OperationProgressView.AllAndJobAndProductTypeAllAndProductionAndOperationTypeAndControlPointAllAndOperationAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping(value = "/sectionAndJobAndProductionDateAndControlPointPage", params = {"section", "productionDate", "controlPoint", "job"})
    public Page<OperationProgress> sectionAndJobAndProductionDateAndControlPointPage(@RequestParam("section") String section, @RequestParam("productionDate") String productionDate, @RequestParam("controlPoint") String controlPoint, @RequestParam("job") String job, Pageable pageable) throws ParseException {
        return new Page(service.findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationJobAndOperationProductionProductionDateAndOperationProductionControlPoint(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(productionDate), new ControlPoint(Integer.valueOf(controlPoint)), new Job(Integer.valueOf(job)), pageable));
    }

    @JsonView(OperationProgressView.All.class)
    @PostMapping
    public OperationProgress save(@RequestBody OperationProgress operationProgress,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            operationProgress = service.save(operationProgress);
            return operationProgress;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<OperationProgress> operationProgresses,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            service.save(operationProgresses);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(OperationProgressView.All.class)
    @GetMapping("/{id}")
    public OperationProgress findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @JsonView(OperationProgressView.All.class)
    @PutMapping("/{id}")
    public OperationProgress updateCustomer(@PathVariable int id, @RequestBody OperationProgress operationProgress,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        operationProgress.setId(id);
        operationProgress = service.save(operationProgress);
        return operationProgress;
    }
}
