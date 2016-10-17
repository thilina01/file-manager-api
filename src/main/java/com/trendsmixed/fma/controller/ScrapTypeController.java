package com.trendsmixed.fma.controller;

import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.ScrapType;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.ScrapTypeService;
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
@RequestMapping("/scrapTypes")
public class ScrapTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ScrapTypeService scrapTypeService;

    @GetMapping
    public List<ScrapType> findAll() {
        return scrapTypeService.findAll();
    }

    @PostMapping
    public ScrapType save(@RequestBody ScrapType scrapType, @RequestHeader(value = "email", defaultValue = "") String email) {
        AppSession appSession = appSessionService.findOne(email);
        if (appSession == null) {
            throw new Error("Unauthorized access");
        } else {
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
    }

    @GetMapping("/{id}")
    public ScrapType findOne(@PathVariable("id") int id) {
        return scrapTypeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable int id) {
        scrapTypeService.delete(id);
        return "Deleted";

    }

    @PutMapping("/{id}")
    public ScrapType updateCustomer(@PathVariable int id, @RequestBody ScrapType scrapType) {
        scrapType.setId(id);
        scrapType = scrapTypeService.save(scrapType);
        return scrapType;
    }
}