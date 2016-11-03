package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.ControlPointRunJob;
import com.trendsmixed.fma.jsonView.ControlPointRunJobView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.ControlPointRunJobService;
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
@RequestMapping("/controlPointRunJobs")
public class ControlPointRunJobController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ControlPointRunJobService controlPointRunJobService;

    
    @GetMapping
    public List<ControlPointRunJob> findAll() {
        return controlPointRunJobService.findAll();
    }

    
    @PostMapping
    public ControlPointRunJob save(@RequestBody ControlPointRunJob controlPointRunJob, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
//            List<ControlPointRunJobManpower> controlPointRunJobManpowers = controlPointRunJob.getControlPointRunJobManpowerList();
//            for (ControlPointRunJobManpower controlPointRunJobManpower : controlPointRunJobManpowers) {
//                controlPointRunJobManpower.setControlPointRunJob(controlPointRunJob);                
//            }
//            
//            List<ControlPointRunJobJob> controlPointRunJobJobs = controlPointRunJob.getControlPointRunJobJobList();
//            for (ControlPointRunJobJob controlPointRunJobJob : controlPointRunJobJobs) {
//                controlPointRunJobJob.setControlPointRunJob(controlPointRunJob);                
//            }
//            List<ControlPointRunJobLoss> controlPointRunJobLosses = controlPointRunJob.getControlPointRunJobLossList();
//            for (ControlPointRunJobLoss controlPointRunJobLoss : controlPointRunJobLosses) {
//                controlPointRunJobLoss.setControlPointRunJob(controlPointRunJob);  
//                
//            }
            
            controlPointRunJob = controlPointRunJobService.save(controlPointRunJob);
            return controlPointRunJob;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ControlPointRunJob findOne(@PathVariable("id") int id) {
        return controlPointRunJobService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointRunJobService.delete(id);

    }

    @PutMapping("/{id}")
    public ControlPointRunJob updateCustomer(@PathVariable int id, @RequestBody ControlPointRunJob controlPointRunJob, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointRunJob.setId(id);
        controlPointRunJob = controlPointRunJobService.save(controlPointRunJob);
        return controlPointRunJob;
    }

}
