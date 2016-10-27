package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.SalesOrderType;
import com.trendsmixed.fma.jsonView.SalesOrderTypeView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.SalesOrderTypeService;
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
@RequestMapping("/salesOrderTypes")
public class SalesOrderTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private SalesOrderTypeService salesOrderTypeService;

    @JsonView(SalesOrderTypeView.All.class)
    @GetMapping
    public List<SalesOrderType> findAll() {
        return salesOrderTypeService.findAll();
    }

    @JsonView(SalesOrderTypeView.All.class)
    @PostMapping
    public SalesOrderType save(@RequestBody SalesOrderType salesOrderType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            salesOrderType = salesOrderTypeService.save(salesOrderType);
            return salesOrderType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public SalesOrderType findOne(@PathVariable("id") int id) {
        return salesOrderTypeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        salesOrderTypeService.delete(id);

    }

    @PutMapping("/{id}")
    public SalesOrderType updateCustomer(@PathVariable int id, @RequestBody SalesOrderType salesOrderType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        salesOrderType.setId(id);
        salesOrderType = salesOrderTypeService.save(salesOrderType);
        return salesOrderType;
    }
}
