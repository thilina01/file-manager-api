package com.trendsmixed.fma.module.suppliertype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/supplierTypes")
public class SupplierTypeController {

    
    private final SupplierTypeService service;

    @JsonView(SupplierTypeView.All.class)
    @GetMapping
    public Iterable<SupplierType> findAll() {
        return service.findAll();
    }

    @JsonView(SupplierTypeView.All.class)
    @GetMapping("/page")
    Page<SupplierType> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(SupplierTypeView.All.class)
    @PostMapping
    public SupplierType save(@RequestBody SupplierType supplierType,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {
            supplierType = service.save(supplierType);
            return supplierType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<SupplierType> supplierTypes,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {

            service.save(supplierTypes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SupplierTypeView.All.class)
    @GetMapping("/{id}")
    public SupplierType findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.delete(id);
    }

    @JsonView(SupplierTypeView.All.class)
    @PutMapping("/{id}")
    public SupplierType updateCustomer(@PathVariable int id, @RequestBody SupplierType supplierType,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        supplierType.setId(id);
        supplierType = service.save(supplierType);
        return supplierType;
    }
}
