package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.ControlPointRunBreakdown;
import com.trendsmixed.fma.jsonView.ControlPointRunBreakdownView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.ControlPointRunBreakdownService;
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
@RequestMapping("/controlPointRunBreakdowns")
public class ControlPointRunBreakdownController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ControlPointRunBreakdownService controlPointRunBreakdownService;

    @JsonView(ControlPointRunBreakdownView.AllAndControlPointRunAllAndMachineAll.class)
    @GetMapping
    public List<ControlPointRunBreakdown> findAll() {
        return controlPointRunBreakdownService.findAll();
    }

    @PostMapping
    public ControlPointRunBreakdown save(@RequestBody ControlPointRunBreakdown controlPointRunBreakdown, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
//            List<ControlPointRunBreakdownManpower> controlPointRunBreakdownManpowers = controlPointRunBreakdown.getControlPointRunBreakdownManpowerList();
//            for (ControlPointRunBreakdownManpower controlPointRunBreakdownManpower : controlPointRunBreakdownManpowers) {
//                controlPointRunBreakdownManpower.setControlPointRunBreakdown(controlPointRunBreakdown);                
//            }
//            
//            List<ControlPointRunBreakdownJob> controlPointRunBreakdownJobs = controlPointRunBreakdown.getControlPointRunBreakdownJobList();
//            for (ControlPointRunBreakdownJob controlPointRunBreakdownJob : controlPointRunBreakdownJobs) {
//                controlPointRunBreakdownJob.setControlPointRunBreakdown(controlPointRunBreakdown);                
//            }
//            List<ControlPointRunBreakdownLoss> controlPointRunBreakdownLosses = controlPointRunBreakdown.getControlPointRunBreakdownLossList();
//            for (ControlPointRunBreakdownLoss controlPointRunBreakdownLoss : controlPointRunBreakdownLosses) {
//                controlPointRunBreakdownLoss.setControlPointRunBreakdown(controlPointRunBreakdown);  
//                
//            }

            controlPointRunBreakdown = controlPointRunBreakdownService.save(controlPointRunBreakdown);
            return controlPointRunBreakdown;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ControlPointRunBreakdownView.AllAndControlPointRunAllAndMachineAll.class)
    @GetMapping("/{id}")
    public ControlPointRunBreakdown findOne(@PathVariable("id") int id) {
        return controlPointRunBreakdownService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointRunBreakdownService.delete(id);

    }

    @PutMapping("/{id}")
    public ControlPointRunBreakdown updateCustomer(@PathVariable int id, @RequestBody ControlPointRunBreakdown controlPointRunBreakdown, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointRunBreakdown.setId(id);
        controlPointRunBreakdown = controlPointRunBreakdownService.save(controlPointRunBreakdown);
        return controlPointRunBreakdown;
    }

}
