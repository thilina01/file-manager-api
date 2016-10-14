package com.trendsmixed.fma.controller;

import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.Job;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.JobService;
import java.util.List;
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
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @PostMapping
    public Job save(@RequestBody Job job, @RequestHeader(value = "email", defaultValue = "") String email) {
        AppSession appSession = appSessionService.findOne(email);
        if (appSession == null) {
            throw new Error("Unauthorized access");
        } else {
            try {
                job = jobService.save(job);
                return job;

            } catch (Throwable e) {
                while (e.getCause() != null) {
                    e = e.getCause();
                }
                throw new Error(e.getMessage());
            }
        }
    }

    @GetMapping("/{id}")
    public Job findOne(@PathVariable("id") int id) {
        return jobService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable int id) {
        jobService.delete(id);
        return "Deleted";

    }

    @PutMapping("/{id}")
    public Job updateCustomer(@PathVariable int id, @RequestBody Job job) {
        job.setId(id);
        job = jobService.save(job);
        return job;
    }
}
