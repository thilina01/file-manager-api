package com.trendsmixed.fma.module.productionoverheadcostperkg;

import com.trendsmixed.fma.module.labourturnover.*;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.ProductionOverheadCostPerKg;
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
@RequestMapping("/productionOverheadCostPerKgs")
public class ProductionOverheadCostPerKgController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ProductionOverheadCostPerKgService service;

    @JsonView(ProductionOverheadCostPerKgView.All.class)
    @GetMapping
    public Iterable<ProductionOverheadCostPerKg> findAll() {
        return service.findAll();
    }

    @JsonView(ProductionOverheadCostPerKgView.All.class)
    @GetMapping("/page")
    Page<ProductionOverheadCostPerKg> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public ProductionOverheadCostPerKg save(@RequestBody ProductionOverheadCostPerKg productionOverheadCostPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            productionOverheadCostPerKg = service.save(productionOverheadCostPerKg);
            return productionOverheadCostPerKg;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ProductionOverheadCostPerKg> productionOverheadCostPerKgs, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(productionOverheadCostPerKgs);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(ProductionOverheadCostPerKgView.All.class)
    public ProductionOverheadCostPerKg findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public ProductionOverheadCostPerKg updateCustomer(@PathVariable int id, @RequestBody ProductionOverheadCostPerKg productionOverheadCostPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        productionOverheadCostPerKg.setId(id);
        productionOverheadCostPerKg = service.save(productionOverheadCostPerKg);
        return productionOverheadCostPerKg;
    }

}
