package com.trendsmixed.fma.controller;

import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.DefectType;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.DefectTypeService;
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
@RequestMapping("/defectTypes")
public class DefectTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private DefectTypeService defectTypeService;

    @GetMapping
    public List<DefectType> findAll() {
        return defectTypeService.findAll();
    }

    @PostMapping
    public DefectType save(@RequestBody DefectType defectType, @RequestHeader(value = "email", defaultValue = "") String email) {
        AppSession appSession = appSessionService.findOne(email);
        if (appSession == null) {
            throw new Error("Unauthorized access");
        } else {
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
    }

    @GetMapping("/{id}")
    public DefectType findOne(@PathVariable("id") int id) {
        return defectTypeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable int id) {
        defectTypeService.delete(id);
        return "Deleted";

    }

    @PutMapping("/{id}")
    public DefectType updateCustomer(@PathVariable int id, @RequestBody DefectType defectType) {
        defectType.setId(id);
        defectType = defectTypeService.save(defectType);
        return defectType;
    }
}
