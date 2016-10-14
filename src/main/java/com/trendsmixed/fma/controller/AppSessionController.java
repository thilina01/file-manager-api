package com.trendsmixed.fma.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.AppSession;
import com.trendsmixed.fma.service.AppSessionService;
import java.util.List;
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
@RequestMapping("/appSessions")
public class AppSessionController {

    @Autowired
    private AppSessionService appSessionService;

    @GetMapping
    public List<AppSession> findAll() {
        return appSessionService.findAll();
    }

    @PostMapping
    public AppSession save(@RequestBody AppSession appSession, @RequestHeader(value = "email", defaultValue = "") String email) {
        appSession = appSessionService.findOne(email);
        if (appSession == null) {
            throw new Error("Unauthorized access");
        } else {
            try {
                appSession = appSessionService.save(appSession);
                return appSession;

            } catch (Throwable e) {
                while (e.getCause() != null) {
                    e = e.getCause();
                }
                throw new Error(e.getMessage());
            }
        }
    }

    @GetMapping("/{id}")
    public AppSession findOne(@PathVariable("id") int id) {
        return appSessionService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable int id) {
        appSessionService.delete(id);
        return "Deleted";

    }

    @PutMapping("/{id}")
    public AppSession updateCustomer(@PathVariable int id, @RequestBody AppSession appSession) {
        appSession.setId(id);
        appSession = appSessionService.save(appSession);
        return appSession;
    }
}
