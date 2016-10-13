package com.trendsmixed.fma.controller;

import com.trendsmixed.fma.entity.AppSession;
import com.trendsmixed.fma.entity.Section;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.WorkCenter;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.WorkCenterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/workCenters")
public class WorkCenterController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private WorkCenterService workCenterService;

    @GetMapping
    public List<WorkCenter> findAll() {
        return workCenterService.findAll();
    }

    @PostMapping
    public WorkCenter save(@RequestBody WorkCenter workCenter, @RequestHeader(value = "email", defaultValue = "") String email) {
        AppSession appSession = appSessionService.findOne(email);
        if (appSession == null) {
            throw new Error("Unauthorized access");
        } else {
            try {
                workCenter = workCenterService.save(workCenter);
                return workCenter;

            } catch (Throwable e) {
                while (e.getCause() != null) {
                    e = e.getCause();
                }
                throw new Error(e.getMessage());
            }
        }
    }
    
    @GetMapping("/{id}")
    public WorkCenter findOne(@PathVariable("id") int id) {
        return workCenterService.findOne(id);
    }

}
