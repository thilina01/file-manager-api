package com.trendsmixed.fma.module.materialcostperkg;

import com.trendsmixed.fma.module.labourturnover.*;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.MaterialCostPerKg;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/materialCostPerKgs")
public class MaterialCostPerKgController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private MaterialCostPerKgService service;

    @JsonView(MaterialCostPerKgView.All.class)
    @GetMapping
    public Iterable<MaterialCostPerKg> findAll() {
        return service.findAll();
    }

    @JsonView(MaterialCostPerKgView.All.class)
    @GetMapping("/page")
    Page<MaterialCostPerKg> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public MaterialCostPerKg save(@RequestBody MaterialCostPerKg materialCostPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            materialCostPerKg = service.save(materialCostPerKg);
            return materialCostPerKg;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<MaterialCostPerKg> materialCostPerKgs, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(materialCostPerKgs);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(MaterialCostPerKgView.All.class)
    public MaterialCostPerKg findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public MaterialCostPerKg updateCustomer(@PathVariable int id, @RequestBody MaterialCostPerKg materialCostPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        materialCostPerKg.setId(id);
        materialCostPerKg = service.save(materialCostPerKg);
        return materialCostPerKg;
    }

}
