package com.trendsmixed.fma.module.job;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.item.ItemService;
import com.trendsmixed.fma.module.jobtype.JobType;
import com.trendsmixed.fma.module.jobtype.JobTypeService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/jobs")
public class JobController {

    
    private final JobService service;
    private final ItemService itemService;
    private final JobTypeService jobTypeService;

    @JsonView(JobView.AllAndItemAllAndJobTypeAll.class)
    @GetMapping
    public Iterable<Job> findAll() {
        return service.findAll();
    }

    @JsonView(JobView.AllAndItemAllAndJobTypeAll.class)
    @GetMapping("/page")
    Page<Job> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }
    
    @GetMapping("/combo/item/{id}")
    List<Combo> comboByItem(@PathVariable("id") int itemId) {
        return service.comboByItem(new Item(itemId));
    }

    @JsonView(JobView.AllAndItemAllAndJobTypeAll.class)
    @GetMapping(value = "/pageByItem")
    public Page<Job> getItem(
        @RequestParam(value = "jobNo", required = false, defaultValue = "0") String jobNo,
        @RequestParam(value = "item", required = false, defaultValue = "0") String item,   
        Pageable pageable) throws ParseException {
        Page<Job> page ;
        if(!jobNo.equals("0")){
            page = new Page(service.findByJobNo(jobNo, pageable));
        }else {
            page = new Page(service.findByItem(new Item(Integer.valueOf(item)),  pageable));
       }
        return page;
    }

    @JsonView(JobView.All.class)
    @PostMapping
    public Job save(@RequestBody Job job) {
        
        try {
            Job existingJob = service.findByJobNo(job.getJobNo());
            if ((job.getId() == null || job.getId() == 0) && existingJob != null) {
                throw new Error("Job Number Already Used!");
            }

            if (job.getId() == null) {
                job.setJobDate(new Date());
                job.setJobType(jobTypeService.findByCode("Forecast"));
            }
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
    public void saveMany(@RequestBody List<Job> jobs) {

        
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
        return service.findById(id);
    }

    @JsonView(JobView.AllAndItemAllAndJobTypeAll.class)
    @GetMapping("/jobNoLike/{query}")
    public Iterable<Job> findByJobNoLike(@PathVariable("query") String query) {
        return service.findByJobNoLike("%"+query+"%");
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
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public Job update(@PathVariable int id, @RequestBody Job job) {
        
        job.setId(id);
        job = service.save(job);
        return job;
    }
}
