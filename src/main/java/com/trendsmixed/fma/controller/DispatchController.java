package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.Dispatch;
import com.trendsmixed.fma.entity.JobDispatch;
import com.trendsmixed.fma.jsonView.DispatchView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.DispatchService;
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
@RequestMapping("/dispatches")
public class DispatchController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private DispatchService dispatchService;

    @JsonView(DispatchView.AllAndCustomerAll.class)
    @GetMapping
    public List<Dispatch> findAll() {
        return dispatchService.findAll();
    }

    @JsonView(DispatchView.All.class)
    @PostMapping
    public Dispatch save(@RequestBody Dispatch dispatch, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            List<JobDispatch> jobDispatchs = dispatch.getJobDispatchList();
            for (JobDispatch jobDispatch : jobDispatchs) {
                jobDispatch.setDispatch(dispatch);
                //Job job = jobDispatch.getJob();                
            }

            dispatch = dispatchService.save(dispatch);
            return dispatch;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Dispatch findOne(@PathVariable("id") int id) {
        return dispatchService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        dispatchService.delete(id);

    }

    @PutMapping("/{id}")
    public Dispatch updateCustomer(@PathVariable int id, @RequestBody Dispatch dispatch, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        dispatch.setId(id);
        dispatch = dispatchService.save(dispatch);
        return dispatch;
    }
}
