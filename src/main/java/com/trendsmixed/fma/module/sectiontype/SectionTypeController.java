package com.trendsmixed.fma.module.sectiontype;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.trendsmixed.fma.utility.Page;

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

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import org.springframework.data.domain.Pageable;

@RestController
@CrossOrigin
@RequestMapping("/sectionTypes")
public class SectionTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private SectionTypeService service;

    @JsonView(SectionTypeView.All.class)
    @GetMapping
    public Iterable<SectionType> findAll() {
        return service.findAll();
    }

    @JsonView(SectionTypeView.All.class)
    @GetMapping("/page")
    Page<SectionType> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));

    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(SectionTypeView.All.class)
    @PostMapping
    public SectionType save(@RequestBody SectionType sectionType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            sectionType = service.save(sectionType);
            return sectionType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<SectionType> sectionTypes, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(sectionTypes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public SectionType findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public SectionType updateCustomer(@PathVariable int id, @RequestBody SectionType sectionType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        sectionType.setId(id);
        sectionType = service.save(sectionType);
        return sectionType;
    }
}
