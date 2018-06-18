package com.trendsmixed.fma.module.jobdispatch;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/jobDispatches")
public class JobDispatchController {

    
    private final JobDispatchService jobDispatchService;

    @JsonView(JobDispatchView.AllAndDispatchAllAndCustomerAllAndJobAllAndItemAll.class)
    @GetMapping
    public List<JobDispatch> findAll() {
        return jobDispatchService.findAll();
    }

    @GetMapping("/{id}")
    public JobDispatch findOne(@PathVariable("id") int id) {
        return jobDispatchService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        jobDispatchService.delete(id);

    }

    @PutMapping("/{id}")
    public JobDispatch updateCustomer(@PathVariable int id, @RequestBody JobDispatch jobDispatch) {
        
        jobDispatch.setId(id);
        jobDispatch = jobDispatchService.save(jobDispatch);
        return jobDispatch;
    }
}
