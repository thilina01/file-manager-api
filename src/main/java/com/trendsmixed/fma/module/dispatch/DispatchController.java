package com.trendsmixed.fma.module.dispatch;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.jobdispatch.JobDispatch;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.job.JobService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.trendsmixed.fma.utility.Page;
import org.springframework.data.domain.Pageable;
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
    private DispatchService  service;
    @Autowired
    private JobService jobService;

    @JsonView(DispatchView.All.class)
    @GetMapping
    public Iterable<Dispatch> findAll() {
        return service.findAll();
    }

    @JsonView(DispatchView.All.class)
    @GetMapping("/page")
    Page<Dispatch> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(DispatchView.All.class)
    @PostMapping
    public Dispatch save(@RequestBody Dispatch dispatch, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            List<JobDispatch> jobDispatchs = dispatch.getJobDispatchList();
            for (JobDispatch jobDispatch : jobDispatchs) {
                jobDispatch.setDispatch(dispatch);
                Job job = jobService.findOne(jobDispatch.getJob().getId());

                double dispatchQuantity = jobDispatch.getQuantity();
                jobService.save(job);
            }

             dispatch = service.save(dispatch);
            return dispatch;
      
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(DispatchView.AllAndCustomerAllAndJobDispatchAll.class)
    @GetMapping("/{id}")
    public Dispatch findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
     public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
   public Dispatch updateCustomer(@PathVariable int id, @RequestBody Dispatch dispatch, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        dispatch.setId(id);
        dispatch = service.save(dispatch);
        return dispatch;
    }
}