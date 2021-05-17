package com.trendsmixed.fma.module.operationprogress;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.log.LogExecution;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.controlpoint.ControlPointService;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.job.JobService;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.section.SectionService;
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
@RequestMapping("/operationProgresses")
public class OperationProgressController {

    private final OperationProgressService service;
    private final SectionService sectionService;
    private final JobService jobService;
    private final ControlPointService controlPointService;

    @LogExecution
    @JsonView(OperationProgressView.All.class)
    @GetMapping
    public Iterable<OperationProgress> findAll() {
        return service.findAll();
    }

    @LogExecution
    @JsonView(OperationProgressView.AllAndJobAndProductTypeAllAndProductionAndOperationTypeAndControlPointAllAndOperationAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping("/page")
    Page<OperationProgress> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @LogExecution
    @JsonView(OperationProgressView.AllAndJobAndProductTypeAllAndProductionAndOperationTypeAndControlPointAllAndOperationAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping(value = "/controlPointAndSectionAndJobAndProductionDateBetween")
    public Page<OperationProgress> getControlPointAndSectionAndJobAndProductionDateBetweenPage(
        @RequestParam(value = "section", required = false, defaultValue = "0") String section,
        @RequestParam(value = "job", required = false, defaultValue = "0") String job,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        @RequestParam(value = "controlPoint", required = false, defaultValue = "0") String controlPoint,
        Pageable pageable) throws ParseException {
        Page<OperationProgress> page ;

        if(controlPoint.equals("0") && section.equals("0") && job.equals("0") ){
            page = new Page(service.findByOperationProductionProductionDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } 
        else if(controlPoint.equals("0") && section.equals("0")){
            page = new Page(service.findByOperationProductionProductionDateBetweenAndOperationJob(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Job(Integer.valueOf(job)), pageable));
        }
        else if(section.equals("0") && job.equals("0")){
            page = new Page(service.findByOperationProductionProductionDateBetweenAndOperationProductionControlPoint(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new ControlPoint(Integer.valueOf(controlPoint)), pageable));
        }
        else if(controlPoint.equals("0") && job.equals("0")){
            page = new Page(service.findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateBetween(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else if(controlPoint.equals("0")){
            page = new Page(service.findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateBetweenAndOperationJob(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Job(Integer.valueOf(job)), pageable));
        }
        else if(section.equals("0")){
            page = new Page(service.findByOperationProductionControlPointAndOperationProductionProductionDateBetweenAndOperationJob(new ControlPoint(Integer.valueOf(controlPoint)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Job(Integer.valueOf(job)), pageable));
        }
        else if(job.equals("0")){
            page = new Page(service.findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateBetweenAndOperationProductionControlPoint(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new ControlPoint(Integer.valueOf(controlPoint)), pageable));
        }
        else{
            page = new Page(service.findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationJobAndOperationProductionProductionDateBetweenAndOperationProductionControlPoint(new Section(Integer.valueOf(section)),new Job(Integer.valueOf(job)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),  new ControlPoint(Integer.valueOf(controlPoint)), pageable));
        }
        return page;
    }

    @LogExecution
    @JsonView(OperationProgressView.AllAndJobAndProductTypeAllAndProductionAndOperationTypeAndControlPointAllAndOperationAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @PostMapping("/pageBySection")
    Page<OperationProgress> pageBySection(Pageable pageable, @RequestBody Section section) {
        if (section.getId() == null) {
            section = sectionService.findByCode(section.getCode());
        }
        return new Page<>(service.findByOperationProductionControlPointWorkCenterCostCenterSection(section, pageable));
    }

    @LogExecution
    @JsonView(OperationProgressView.AllAndJobAndProductTypeAllAndProductionAndOperationTypeAndControlPointAllAndOperationAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @PostMapping("/pageByJob")
    Page<OperationProgress> pageByJob(Pageable pageable, @RequestBody Job job) {
        if (job.getId() == null) {
            job = jobService.findByJobNo(job.getJobNo());
        }
        return new Page<>(service.findByOperationJob(job, pageable));
    }

    @LogExecution
    @JsonView(OperationProgressView.AllAndJobAndProductTypeAllAndProductionAndOperationTypeAndControlPointAllAndOperationAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @PostMapping("/pageByControlPoint")
    Page<OperationProgress> pageByControlPoint(Pageable pageable, @RequestBody ControlPoint controlPoint) {
        if (controlPoint.getId() == null) {
            controlPoint = controlPointService.findByCode(controlPoint.getCode());
        }
        return new Page<>(service.findByOperationProductionControlPoint(controlPoint, pageable));
    }

    @LogExecution
    @JsonView(OperationProgressView.All.class)
    @PostMapping
    public OperationProgress save(@RequestBody OperationProgress operationProgress,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
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

    @LogExecution
    @PostMapping("/many")
    public void saveMany(@RequestBody List<OperationProgress> operationProgresses,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {

            service.save(operationProgresses);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @LogExecution
    @JsonView(OperationProgressView.All.class)
    @GetMapping("/{id}")
    public OperationProgress findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.deleteById(id);
    }

    @LogExecution
    @JsonView(OperationProgressView.All.class)
    @PutMapping("/{id}")
    public OperationProgress updateCustomer(@PathVariable int id, @RequestBody OperationProgress operationProgress,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        operationProgress.setId(id);
        operationProgress = service.save(operationProgress);
        return operationProgress;
    }
}
