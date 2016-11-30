package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.JobDispatch;
import com.trendsmixed.fma.jsonView.JobDispatchView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.JobDispatchService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/jobDispatches")
public class JobDispatchController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private JobDispatchService jobDispatchService;

    @JsonView(JobDispatchView.AllAndDispatchAllAndCustomerAllAndJobAllAndItemAll.class)
    @GetMapping
    public List<JobDispatch> findAll() {
        return jobDispatchService.findAll();
    }
//
//    @JsonView(DispatchView.All.class)
//    @PostMapping
//    public Dispatch save(@RequestBody JobDispatch dispatch, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
//        appSessionService.isValid(email, request);
//        try {
//            List<JobDispatch> jobDispatchs = dispatch.getJobDispatchList();
//            for (JobDispatch jobDispatch : jobDispatchs) {
//                jobDispatch.setDispatch(dispatch);
//                //Job job = jobDispatch.getJob();                
//            }
//
//            dispatch = jobDispatchService.save(dispatch);
//            return dispatch;
//
//        } catch (Throwable e) {
//            while (e.getCause() != null) {
//                e = e.getCause();
//            }
//            throw new Error(e.getMessage());
//        }
//    }

    @GetMapping("/{id}")
    public JobDispatch findOne(@PathVariable("id") int id) {
        return jobDispatchService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        jobDispatchService.delete(id);

    }

    @PutMapping("/{id}")
    public JobDispatch updateCustomer(@PathVariable int id, @RequestBody JobDispatch jobDispatch, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        jobDispatch.setId(id);
        jobDispatch = jobDispatchService.save(jobDispatch);
        return jobDispatch;
    }
}
