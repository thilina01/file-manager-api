package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.Status;
import com.trendsmixed.fma.jsonView.StatusView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.StatusService;
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
@RequestMapping("/statuses")
public class StatusController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private StatusService statusService;

    @JsonView(StatusView.All.class)
    @GetMapping
    public List<Status> findAll() {
        return statusService.findAll();
    }

    @PostMapping
    public Status save(@RequestBody Status status, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            status = statusService.save(status);
            return status;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Status> statuss, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            for (Status status : statuss) {
                status.setName(status.getName().trim());
                Status existingStatus = statusService.findByName(status.getName());
                if (existingStatus != null) {
                    status.setId(existingStatus.getId());
                }
            }
            statusService.save(statuss);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Status findOne(@PathVariable("id") int id) {
        return statusService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        statusService.delete(id);

    }

    @PutMapping("/{id}")
    public Status updateCustomer(@PathVariable int id, @RequestBody Status status, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        status.setId(id);
        status = statusService.save(status);
        return status;
    }

}
