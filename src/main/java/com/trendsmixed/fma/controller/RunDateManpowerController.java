package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.RunDateManpower;
import com.trendsmixed.fma.jsonView.RunDateManpowerView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.RunDateManpowerService;
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
@RequestMapping("/runDateManpowers")
public class RunDateManpowerController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private RunDateManpowerService runDateManpowerService;

    @JsonView(RunDateManpowerView.All.class)
    @GetMapping
    public List<RunDateManpower> findAll() {
        return runDateManpowerService.findAll();
    }

    @JsonView(RunDateManpowerView.All.class)
    @PostMapping
    public RunDateManpower save(@RequestBody RunDateManpower runDateManpower, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            runDateManpower = runDateManpowerService.save(runDateManpower);
            return runDateManpower;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public RunDateManpower findOne(@PathVariable("id") int id) {
        return runDateManpowerService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        runDateManpowerService.delete(id);

    }

    @PutMapping("/{id}")
    public RunDateManpower updateCustomer(@PathVariable int id, @RequestBody RunDateManpower runDateManpower, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        runDateManpower.setId(id);
        runDateManpower = runDateManpowerService.save(runDateManpower);
        return runDateManpower;
    }

}
