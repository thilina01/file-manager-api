package com.trendsmixed.fma.module.application;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import org.springframework.web.bind.annotation.*;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/applications")
public class ApplicationController {

    private final AppSessionService appSessionService;
    private final ApplicationService service;

    @JsonView(ApplicationView.All.class)
    @GetMapping
    public Iterable<Application> findAll() {
        return service.findAll();
    }

    @JsonView(ApplicationView.All.class)
    @GetMapping("/page")
    Page<Application> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(ApplicationView.All.class)
    @PostMapping
    public Application save(@RequestBody Application application, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            application = service.save(application);
            return application;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ApplicationView.All.class)
    @GetMapping("/{id}")
    public Application findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(ApplicationView.All.class)
    @PutMapping("/{id}")
    public Application updateCustomer(@PathVariable int id, @RequestBody Application application, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        application.setId(id);
        application = service.save(application);
        return application;
    }
}
