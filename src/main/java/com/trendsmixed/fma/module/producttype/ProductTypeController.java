package com.trendsmixed.fma.module.producttype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.module.appsession.AppSessionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("/productTypes")
public class ProductTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ProductTypeService service;

    @JsonView(ProductTypeView.All.class)
    @GetMapping
    public Iterable<ProductType> findAll() {
        return service.findAll();
    }

    @JsonView(ProductTypeView.All.class)
    @GetMapping("/page")
    Page<ProductType> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(ProductTypeView.All.class)
    @PostMapping
    public ProductType save(@RequestBody ProductType productType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            productType = service.save(productType);
            return productType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ProductType> productTypes, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(productTypes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ProductType findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public ProductType updateCustomer(@PathVariable int id, @RequestBody ProductType productType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        productType.setId(id);
        productType = service.save(productType);
        return productType;
    }
}
