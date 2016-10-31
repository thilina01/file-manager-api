package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.AppSession;
import com.trendsmixed.fma.entity.Breakdown;
import com.trendsmixed.fma.jsonView.BreakdownView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.BreakdownService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/breakdowns")
public class BreakdownController {

    @Autowired
    private BreakdownService breakdownService;
    @Autowired
    private AppSessionService appSessionService;

    @PostMapping
    public Breakdown save(@RequestBody Breakdown breakdown, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            breakdown = breakdownService.save(breakdown);
            return breakdown;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping
    @JsonView(BreakdownView.All.class)
    public List<Breakdown> findAll() {
        return breakdownService.findAll();
    }

    @GetMapping("/{id}")
    public Breakdown findOne(@PathVariable("id") int id) {
        return breakdownService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        breakdownService.delete(id);

    }

    @PutMapping("/{id}")
    public Breakdown updateCustomer(@PathVariable int id, @RequestBody Breakdown breakdown, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        breakdown.setId(id);
        breakdown = breakdownService.save(breakdown);
        return breakdown;
    }
}
