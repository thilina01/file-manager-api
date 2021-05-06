package com.trendsmixed.fma.module.jobtype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/jobTypes")
public class JobTypeController {

    
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
    public JobType save(@RequestBody JobType jobType) {
        
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
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public JobType updateCustomer(@PathVariable int id, @RequestBody JobType jobType) {
        
        jobType.setId(id);
        jobType = service.save(jobType);
        return jobType;
    }
}
