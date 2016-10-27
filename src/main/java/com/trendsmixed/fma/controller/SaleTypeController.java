package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.SaleType;
import com.trendsmixed.fma.jsonView.SaleTypeView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.SaleTypeService;
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
@RequestMapping("/saleTypes")
public class SaleTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private SaleTypeService saleTypeService;

    @JsonView(SaleTypeView.All.class)
    @GetMapping
    public List<SaleType> findAll() {
        return saleTypeService.findAll();
    }

    @JsonView(SaleTypeView.All.class)
    @PostMapping
    public SaleType save(@RequestBody SaleType saleType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            saleType = saleTypeService.save(saleType);
            return saleType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public SaleType findOne(@PathVariable("id") int id) {
        return saleTypeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        saleTypeService.delete(id);

    }

    @PutMapping("/{id}")
    public SaleType updateCustomer(@PathVariable int id, @RequestBody SaleType saleType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        saleType.setId(id);
        saleType = saleTypeService.save(saleType);
        return saleType;
    }

}
