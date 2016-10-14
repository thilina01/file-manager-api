package com.trendsmixed.fma.controller;

import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.ProductType;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.ProductTypeService;
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
@RequestMapping("/productTypes")
public class ProductTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping
    public List<ProductType> findAll() {
        return productTypeService.findAll();
    }

    @PostMapping
    public ProductType save(@RequestBody ProductType productType, @RequestHeader(value = "email", defaultValue = "") String email) {
        AppSession appSession = appSessionService.findOne(email);
        if (appSession == null) {
            throw new Error("Unauthorized access");
        } else {
            try {
                productType = productTypeService.save(productType);
                return productType;

            } catch (Throwable e) {
                while (e.getCause() != null) {
                    e = e.getCause();
                }
                throw new Error(e.getMessage());
            }
        }
    }

    @GetMapping("/{id}")
    public ProductType findOne(@PathVariable("id") int id) {
        return productTypeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable int id) {
        productTypeService.delete(id);
        return "Deleted";

    }

    @PutMapping("/{id}")
    public ProductType updateCustomer(@PathVariable int id, @RequestBody ProductType productType) {
        productType.setId(id);
        productType = productTypeService.save(productType);
        return productType;
    }
}
