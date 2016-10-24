package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.PurchaseOrderType;
import com.trendsmixed.fma.jsonView.PurchaseOrderTypeView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.PurchaseOrderTypeService;
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
@RequestMapping("/purchaseOrderTypes")
public class PurchaseOrderTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private PurchaseOrderTypeService purchaseOrderTypeService;

    @JsonView(PurchaseOrderTypeView.AlL.class)
    @GetMapping
    public List<PurchaseOrderType> findAll() {
        return purchaseOrderTypeService.findAll();
    }

    @PostMapping
    public PurchaseOrderType save(@RequestBody PurchaseOrderType purchaseOrderType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            purchaseOrderType = purchaseOrderTypeService.save(purchaseOrderType);
            return purchaseOrderType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public PurchaseOrderType findOne(@PathVariable("id") int id) {
        return purchaseOrderTypeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        purchaseOrderTypeService.delete(id);

    }

    @PutMapping("/{id}")
    public PurchaseOrderType updateCustomer(@PathVariable int id, @RequestBody PurchaseOrderType purchaseOrderType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        purchaseOrderType.setId(id);
        purchaseOrderType = purchaseOrderTypeService.save(purchaseOrderType);
        return purchaseOrderType;
    }
}
