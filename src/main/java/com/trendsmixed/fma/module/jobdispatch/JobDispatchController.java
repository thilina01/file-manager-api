package com.trendsmixed.fma.module.jobdispatch;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/jobDispatches")
public class JobDispatchController {

    private final AppSessionService appSessionService;
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
