package com.trendsmixed.fma.module.producttype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/productTypes")
public class ProductTypeController {

    
    private final ProductTypeService service;

    @JsonView(ProductTypeView.All.class)
    @GetMapping
    public Iterable<ProductType> findAll() {
        return service.findAll();
    }

    @JsonView(ProductTypeView.All.class)
    @GetMapping("/page")
    Page<ProductType> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(ProductTypeView.All.class)
    @PostMapping
    public ProductType save(@RequestBody ProductType productType) {
        
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
    public void saveMany(@RequestBody List<ProductType> productTypes) {

        
        try {
            service.save(productTypes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ProductTypeView.All.class)
    @GetMapping("/{id}")
    public ProductType findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @PutMapping("/{id}")
    public ProductType updateCustomer(@PathVariable int id, @RequestBody ProductType productType) {
        
        productType.setId(id);
        productType = service.save(productType);
        return productType;
    }
}
