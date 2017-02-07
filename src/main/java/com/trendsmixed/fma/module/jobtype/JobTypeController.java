package com.trendsmixed.fma.module.jobtype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.JobType;
import com.trendsmixed.fma.module.jobtype.JobTypeView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/jobTypes")
public class JobTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private JobTypeService jobTypeService;

    @JsonView(JobTypeView.AlL.class)
    @GetMapping
    public List<JobType> findAll() {
        return jobTypeService.findAll();
    }

    @PostMapping
    public JobType save(@RequestBody JobType jobType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            jobType = jobTypeService.save(jobType);
            return jobType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public JobType findOne(@PathVariable("id") int id) {
        return jobTypeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        jobTypeService.delete(id);

    }

    @PutMapping("/{id}")
    public JobType updateCustomer(@PathVariable int id, @RequestBody JobType jobType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        jobType.setId(id);
        jobType = jobTypeService.save(jobType);
        return jobType;
    }
}
