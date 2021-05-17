package com.trendsmixed.fma.module.salesvalue;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/salesValues")
public class SalesValueController {

    
    private final SalesValueService service;

    @JsonView(SalesValueView.All.class)
    @GetMapping
    public Iterable<SalesValue> findAll() {
        return service.findAll();
    }

    @JsonView(SalesValueView.All.class)
    @GetMapping("/page")
    Page<SalesValue> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public SalesValue save(@RequestBody SalesValue salesValue) {

        
        try {
            salesValue = service.save(salesValue);
            return salesValue;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<SalesValue> salesValues) {

        
        try {
            service.save(salesValues);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(SalesValueView.All.class)
    public SalesValue findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public SalesValue updateCustomer(@PathVariable int id, @RequestBody SalesValue salesValue) {
        
        salesValue.setId(id);
        salesValue = service.save(salesValue);
        return salesValue;
    }

}
