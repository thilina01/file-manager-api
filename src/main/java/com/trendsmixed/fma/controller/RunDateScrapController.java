package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.RunDateScrap;
import com.trendsmixed.fma.jsonView.RunDateScrapView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.RunDateScrapService;
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
@RequestMapping("/runDateScraps")
public class RunDateScrapController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private RunDateScrapService runDateScrapService;

    @JsonView(RunDateScrapView.All.class)
    @GetMapping
    public List<RunDateScrap> findAll() {
        return runDateScrapService.findAll();
    }

    @JsonView(RunDateScrapView.All.class)
    @PostMapping
    public RunDateScrap save(@RequestBody RunDateScrap runDateScrap, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            runDateScrap = runDateScrapService.save(runDateScrap);
            return runDateScrap;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public RunDateScrap findOne(@PathVariable("id") int id) {
        return runDateScrapService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        runDateScrapService.delete(id);

    }

    @PutMapping("/{id}")
    public RunDateScrap updateCustomer(@PathVariable int id, @RequestBody RunDateScrap runDateScrap, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        runDateScrap.setId(id);
        runDateScrap = runDateScrapService.save(runDateScrap);
        return runDateScrap;
    }

}
