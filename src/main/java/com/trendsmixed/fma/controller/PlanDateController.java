package com.trendsmixed.fma.controller;

import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.PlanDate;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.PlanDateService;
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
@RequestMapping("/planDates")
public class PlanDateController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private PlanDateService planDateService;

    @GetMapping
    public List<PlanDate> findAll() {
        return planDateService.findAll();
    }

    @PostMapping
    public PlanDate save(@RequestBody PlanDate planDate, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            planDate = planDateService.save(planDate);
            return planDate;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public PlanDate findOne(@PathVariable("id") int id) {
        return planDateService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable int id) {
        planDateService.delete(id);
        return "Deleted";

    }

    @PutMapping("/{id}")
    public PlanDate updateCustomer(@PathVariable int id, @RequestBody PlanDate planDate) {
        planDate.setId(id);
        planDate = planDateService.save(planDate);
        return planDate;
    }
}
