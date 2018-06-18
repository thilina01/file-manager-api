package com.trendsmixed.fma.module.packagingspecification;

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
@RequestMapping("/packagingSpecifications")
public class PackagingSpecificationController {

    
    private final PackagingSpecificationService service;

    @JsonView(PackagingSpecificationView.AllAndPalletSizeAndItem.class)
    @GetMapping
    public Iterable<PackagingSpecification> findAll() {
        return service.findAll();
    } 

    @JsonView(PackagingSpecificationView.AllAndPalletSizeAndItem.class)
    @GetMapping("/page")
    Page<PackagingSpecification> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @GetMapping("/comboByItem/{id}")
    List<Combo> comboByItem(@PathVariable("id") int id) {
        return service.getComboByItemId(id);
    }

    @PostMapping
    public PackagingSpecification save(@RequestBody PackagingSpecification packagingSpecification) {
        
        try {
            packagingSpecification = service.save(packagingSpecification);
            return packagingSpecification;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(PackagingSpecificationView.AllAndPalletSizeAndItem.class)
    @GetMapping("/{id}")
    public PackagingSpecification findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }
    @JsonView(PackagingSpecificationView.AllAndPalletSizeAndItem.class)
    @PutMapping("/{id}")
    public PackagingSpecification updateCustomer(@PathVariable int id, @RequestBody PackagingSpecification packagingSpecification) {
        
        packagingSpecification.setId(id);
        packagingSpecification = service.save(packagingSpecification);
        return packagingSpecification;
    }
}
