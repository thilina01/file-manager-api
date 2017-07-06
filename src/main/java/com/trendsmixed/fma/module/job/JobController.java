package com.trendsmixed.fma.module.job;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.Item;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.Job;
import com.trendsmixed.fma.entity.JobType;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.item.ItemService;
import com.trendsmixed.fma.module.jobtype.JobTypeService;
import com.trendsmixed.fma.utility.Page;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private JobService service;
    @Autowired
    private ItemService itemService;
    @Autowired
    private JobTypeService jobTypeService;

    @JsonView(JobView.AllAndItemAllAndJobTypeAll.class)
    @GetMapping
    public Iterable<Job> findAll() {
        return service.findAll();
    }
    @JsonView(JobView.AllAndItemAllAndJobTypeAll.class)
    @GetMapping("/page")
	Page<Job> page( Pageable pageable){
    	return service.findAll(pageable);
	} 
    
    @GetMapping("/combo")
	List<Combo> combo(){
    	return service.getCombo();
	} 
	
    @JsonView(JobView.All.class)
    @PostMapping
    public Job save(@RequestBody Job job, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            job.setRemainingQuantity(job.getQuantity());
            job = service.save(job);
            return job;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Job> jobs, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            List<Job> jobsToSave = new ArrayList<>();
            for (Job job : jobs) {
                Job existingJob = service.findByJobNo(job.getJobNo());
                if (existingJob != null) {
                    job.setId(existingJob.getId());
                }
                JobType jobType = job.getJobType();
                if (jobType != null) {
                    String jobTypeCode = jobType.getCode().trim();
                    if (jobTypeCode != null) {
                        jobType = jobTypeService.findByCode(jobTypeCode);
                        if (jobType == null) {
                            jobType = new JobType();
                            jobType.setCode(jobTypeCode);
                            jobType = jobTypeService.save(jobType);
                        }
                        job.setJobType(jobType);
                    }
                }
                Item item = job.getItem();
                if (item != null) {
                    item = itemService.findByCode(item.getCode());
                    if (item != null) {
                        job.setItem(item);
                        jobsToSave.add(job);
                    }
                }
            }
            service.save(jobsToSave);
        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }
    
    @JsonView(JobView.AllAndItemAllAndJobTypeAll.class)
    @GetMapping("/{id}")
    public Job findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }
    
    @JsonView(JobView.AllAndItemAllAndJobTypeAll.class)
    @GetMapping("/jobNo/{jobNo}")
    public Job findByJobNo(@PathVariable("jobNo") String jobNo) {
        return service.findByJobNo(jobNo);
    }
    
    @GetMapping("/table")
    public List findForTable() {
        return service.findForTable();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @PutMapping("/{id}")
    public Job update(@PathVariable int id, @RequestBody Job job, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        job.setId(id);
        job = service.save(job);
        return job;
    }
}
