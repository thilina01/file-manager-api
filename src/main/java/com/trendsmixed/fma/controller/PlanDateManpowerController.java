package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.PlanDateManpower;
import com.trendsmixed.fma.jsonView.PlanDateManpowerView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.PlanDateManpowerService;
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
@RequestMapping("/planDateManpowers")
public class PlanDateManpowerController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private PlanDateManpowerService planDateManpowerService;

    @JsonView(PlanDateManpowerView.All.class)
    @GetMapping
    public List<PlanDateManpower> findAll() {
        return planDateManpowerService.findAll();
    }

    @JsonView(PlanDateManpowerView.All.class)
    @PostMapping
    public PlanDateManpower save(@RequestBody PlanDateManpower planDateManpower, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            planDateManpower = planDateManpowerService.save(planDateManpower);
            return planDateManpower;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public PlanDateManpower findOne(@PathVariable("id") int id) {
        return planDateManpowerService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        planDateManpowerService.delete(id);

    }

    @PutMapping("/{id}")
    public PlanDateManpower updateCustomer(@PathVariable int id, @RequestBody PlanDateManpower planDateManpower, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        planDateManpower.setId(id);
        planDateManpower = planDateManpowerService.save(planDateManpower);
        return planDateManpower;
    }
}
