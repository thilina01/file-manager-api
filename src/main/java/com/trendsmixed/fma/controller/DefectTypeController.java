package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.DefectType;
import com.trendsmixed.fma.jsonView.DefectTypeView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.DefectTypeService;
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
@RequestMapping("/defectTypes")
public class DefectTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private DefectTypeService defectTypeService;

    @JsonView(DefectTypeView.All.class)
    @GetMapping
    public List<DefectType> findAll() {
        return defectTypeService.findAll();
    }

    @JsonView(DefectTypeView.All.class)
    @PostMapping
    public DefectType save(@RequestBody DefectType defectType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            defectType = defectTypeService.save(defectType);
            return defectType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public DefectType findOne(@PathVariable("id") int id) {
        return defectTypeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        defectTypeService.delete(id);

    }

    @PutMapping("/{id}")
    public DefectType updateCustomer(@PathVariable int id, @RequestBody DefectType defectType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        defectType.setId(id);
        defectType = defectTypeService.save(defectType);
        return defectType;
    }
}
