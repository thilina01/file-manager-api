package com.trendsmixed.fma.module.treatmenttype;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
import com.trendsmixed.fma.utility.Page;

@RestController
@CrossOrigin
@RequestMapping("/treatmentTypes")
public class TreatmentTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private TreatmentTypeService service;

    @JsonView(TreatmentTypeView.All.class)
    @GetMapping
    public Iterable<TreatmentType> findAll() {
        return service.findAll();
    }

    @JsonView(TreatmentTypeView.All.class)
    @GetMapping("/page")
    Page<TreatmentType> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(TreatmentTypeView.All.class)
    @PostMapping
    public TreatmentType save(@RequestBody TreatmentType treatmentType,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            treatmentType = service.save(treatmentType);
            return treatmentType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<TreatmentType> treatmentTypes,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            service.save(treatmentTypes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(TreatmentTypeView.All.class)
    @GetMapping("/{id}")
    public TreatmentType findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @JsonView(TreatmentTypeView.All.class)
    @PutMapping("/{id}")
    public TreatmentType updateCustomer(@PathVariable int id, @RequestBody TreatmentType treatmentType,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        treatmentType.setId(id);
        treatmentType = service.save(treatmentType);
        return treatmentType;
    }
}
