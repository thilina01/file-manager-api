package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.ControlPointPlan;
import com.trendsmixed.fma.entity.ControlPointPlanJob;
import com.trendsmixed.fma.entity.ControlPointPlanManpower;
import com.trendsmixed.fma.jsonView.ControlPointPlanView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.ControlPointPlanService;
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
@RequestMapping("/controlPointPlans")
public class ControlPointPlanController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ControlPointPlanService controlPointPlanService;
    
    @JsonView(ControlPointPlanView.All.class)
    @GetMapping
    public List<ControlPointPlan> findAll() {
        return controlPointPlanService.findAll();
    }

    @JsonView(ControlPointPlanView.All.class)
    @PostMapping
    public ControlPointPlan save(@RequestBody ControlPointPlan controlPointPlan, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            List<ControlPointPlanJob> controlPointPlanJobs = controlPointPlan.getControlPointPlanJobList();
            if (controlPointPlanJobs != null) {
                for (ControlPointPlanJob controlPointPlanJob : controlPointPlanJobs) {
                    controlPointPlanJob.setControlPointPlan(controlPointPlan);
                }
            }

            List<ControlPointPlanManpower> controlPointPlanManpowers = controlPointPlan.getControlPointPlanManpowerList();
            if (controlPointPlanManpowers != null) {
                for (ControlPointPlanManpower controlPointPlanManpower : controlPointPlanManpowers) {
                    controlPointPlanManpower.setControlPointPlan(controlPointPlan);
                }
            }

            controlPointPlan = controlPointPlanService.save(controlPointPlan);
            return controlPointPlan;

        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ControlPointPlan findOne(@PathVariable("id") int id) {
        return controlPointPlanService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointPlanService.delete(id);

    }

    @PutMapping("/{id}")
    public ControlPointPlan updateCustomer(@PathVariable int id, @RequestBody ControlPointPlan controlPointPlan, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointPlan.setId(id);
        controlPointPlan = controlPointPlanService.save(controlPointPlan);
        return controlPointPlan;
    }

}
