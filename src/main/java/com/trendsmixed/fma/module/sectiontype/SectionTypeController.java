package com.trendsmixed.fma.module.sectiontype;

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

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.SectionType;
import com.trendsmixed.fma.module.appsession.AppSessionService;

@RestController
@CrossOrigin
@RequestMapping("/sectionTypes")
public class SectionTypeController {

    @Autowired
    private SectionTypeService sectionTypeService;
    @Autowired
    private AppSessionService appSessionService;

    @PostMapping
    public SectionType save(@RequestBody SectionType sectionType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            sectionType = sectionTypeService.save(sectionType);
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
            for (SectionType sectionType : sectionTypes) {
                sectionType.setCode(sectionType.getCode().trim());
                sectionType.setName(sectionType.getName().trim());
                SectionType existingSectionType = sectionTypeService.findByCode(sectionType.getCode());
                if (existingSectionType != null) {
                    sectionType.setId(existingSectionType.getId());
                }
            }
            sectionTypeService.save(sectionTypes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping
    @JsonView(SectionTypeView.All.class)
    public List<SectionType> findAll() {
        return sectionTypeService.findAll();
    }

    @GetMapping("/{id}")
    public SectionType findOne(@PathVariable("id") int id) {
        return sectionTypeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        sectionTypeService.delete(id);

    }

    @PutMapping("/{id}")
    public SectionType updateCustomer(@PathVariable int id, @RequestBody SectionType sectionType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        sectionType.setId(id);
        sectionType = sectionTypeService.save(sectionType);
        return sectionType;
    }
}
