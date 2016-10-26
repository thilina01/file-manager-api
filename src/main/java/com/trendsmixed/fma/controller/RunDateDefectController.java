package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.RunDateDefect;
import com.trendsmixed.fma.jsonView.RunDateDefectView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.RunDateDefectService;
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
@RequestMapping("/runDateDefects")
public class RunDateDefectController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private RunDateDefectService runDateDefectService;

    @JsonView(RunDateDefectView.All.class)
    @GetMapping
    public List<RunDateDefect> findAll() {
        return runDateDefectService.findAll();
    }

    @JsonView(RunDateDefectView.All.class)
    @PostMapping
    public RunDateDefect save(@RequestBody RunDateDefect runDateDefect, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            runDateDefect = runDateDefectService.save(runDateDefect);
            return runDateDefect;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public RunDateDefect findOne(@PathVariable("id") int id) {
        return runDateDefectService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        runDateDefectService.delete(id);

    }

    @PutMapping("/{id}")
    public RunDateDefect updateCustomer(@PathVariable int id, @RequestBody RunDateDefect runDateDefect, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        runDateDefect.setId(id);
        runDateDefect = runDateDefectService.save(runDateDefect);
        return runDateDefect;
    }

}
