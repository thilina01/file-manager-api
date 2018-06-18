package com.trendsmixed.fma.module.supplier;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/suppliers")
public class SupplierController {

    
    private final SupplierService service;

    @JsonView(SupplierView.All.class)
    @GetMapping
    public Iterable<Supplier> findAll() {
        return service.findAll();
    }

    @JsonView(SupplierView.AllAndCurrencyAllAndSupplierTypeAllAndDeliveryTermAllAndPaymentTermAll.class)
    @GetMapping("/page")
    Page<Supplier> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @JsonView(SupplierView.All.class)
    @PostMapping
    public Supplier save(@RequestBody Supplier supplier, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        try {
            supplier = service.save(supplier);
            return supplier;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Supplier> suppliers,
            @RequestHeader(value = "email", defaultValue = "") String email) {

        
        try {
            service.save(suppliers);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SupplierView.AllAndCurrencyAllAndSupplierTypeAllAndDeliveryTermAllAndPaymentTermAll.class)
    @GetMapping("/{id}")
    public Supplier findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.delete(id);

    }

    @JsonView(SupplierView.All.class)
    @PutMapping("/{id}")
    public Supplier updateCustomer(@PathVariable int id, @RequestBody Supplier supplier,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        supplier.setId(id);
        supplier = service.save(supplier);
        return supplier;
    }
}
