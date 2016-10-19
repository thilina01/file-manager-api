package com.trendsmixed.fma.controller;

import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.RunDate;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.RunDateService;
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
@RequestMapping("/runDates")
public class RunDateController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private RunDateService runDateService;

    @GetMapping
    public List<RunDate> findAll() {
        return runDateService.findAll();
    }

    @PostMapping
    public RunDate save(@RequestBody RunDate runDate, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        AppSession appSession = appSessionService.findOne(email);
        if (appSession == null) {
            throw new Error("Unauthorized access");
        } else {
            try {
                runDate = runDateService.save(runDate);
                return runDate;

            } catch (Throwable e) {
                while (e.getCause() != null) {
                    e = e.getCause();
                }
                throw new Error(e.getMessage());
            }
        }
    }

    @GetMapping("/{id}")
    public RunDate findOne(@PathVariable("id") int id) {
        return runDateService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable int id) {
        runDateService.delete(id);
        return "Deleted";

    }

    @PutMapping("/{id}")
    public RunDate updateCustomer(@PathVariable int id, @RequestBody RunDate runDate) {
        runDate.setId(id);
        runDate = runDateService.save(runDate);
        return runDate;
    }

}
