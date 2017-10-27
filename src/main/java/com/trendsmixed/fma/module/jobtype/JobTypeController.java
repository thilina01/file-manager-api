package com.trendsmixed.fma.module.jobtype;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/jobTypes")
public class JobTypeController {

    private final AppSessionService appSessionService;
    private final JobTypeService service;

    @JsonView(JobTypeView.All.class)
    @GetMapping
    public Iterable<JobType> findAll() {
        return service.findAll();
    }

    @JsonView(JobTypeView.All.class)
    @GetMapping("/page")
    Page<JobType> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public JobType save(@RequestBody JobType jobType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            jobType = service.save(jobType);
            return jobType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(JobTypeView.All.class)
    @GetMapping("/{id}")
    public JobType findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public JobType updateCustomer(@PathVariable int id, @RequestBody JobType jobType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        jobType.setId(id);
        jobType = service.save(jobType);
        return jobType;
    }
}
