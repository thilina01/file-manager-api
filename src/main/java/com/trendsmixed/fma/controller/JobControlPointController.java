package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.JobControlPoint;
import com.trendsmixed.fma.jsonView.JobControlPointView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.JobControlPointService;
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
@RequestMapping("/jobControlPoints")
public class JobControlPointController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private JobControlPointService jobControlPointService;


    @GetMapping
    public List<JobControlPoint> findAll() {
        return jobControlPointService.findAll();
    }

    
    @PostMapping
    public JobControlPoint save(@RequestBody JobControlPoint jobControlPoint, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            jobControlPoint = jobControlPointService.save(jobControlPoint);
            return jobControlPoint;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public JobControlPoint findOne(@PathVariable("id") int id) {
        return jobControlPointService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        jobControlPointService.delete(id);

    }

    @PutMapping("/{id}")
    public JobControlPoint updateCustomer(@PathVariable int id, @RequestBody JobControlPoint jobControlPoint, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        jobControlPoint.setId(id);
        jobControlPoint = jobControlPointService.save(jobControlPoint);
        return jobControlPoint;
    }

}
