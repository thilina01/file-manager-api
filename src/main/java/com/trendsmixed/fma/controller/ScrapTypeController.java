package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.ScrapType;
import com.trendsmixed.fma.jsonView.ScrapTypeView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.ScrapTypeService;
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
@RequestMapping("/scrapTypes")
public class ScrapTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ScrapTypeService scrapTypeService;

    @JsonView(ScrapTypeView.All.class)
    @GetMapping
    public List<ScrapType> findAll() {
        return scrapTypeService.findAll();
    }

    @JsonView(ScrapTypeView.All.class)
    @PostMapping
    public ScrapType save(@RequestBody ScrapType scrapType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            scrapType = scrapTypeService.save(scrapType);
            return scrapType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ScrapType findOne(@PathVariable("id") int id) {
        return scrapTypeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        scrapTypeService.delete(id);

    }

    @PutMapping("/{id}")
    public ScrapType updateCustomer(@PathVariable int id, @RequestBody ScrapType scrapType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        scrapType.setId(id);
        scrapType = scrapTypeService.save(scrapType);
        return scrapType;
    }
}
