package com.trendsmixed.fma.module.salesweight;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/salesWeights")
public class SalesWeightController {

    
    private final SalesWeightService service;

    @JsonView(SalesWeightView.All.class)
    @GetMapping
    public Iterable<SalesWeight> findAll() {
        return service.findAll();
    }

    @JsonView(SalesWeightView.All.class)
    @GetMapping("/page")
    Page<SalesWeight> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public SalesWeight save(@RequestBody SalesWeight salesWeight) {

        
        try {
            salesWeight = service.save(salesWeight);
            return salesWeight;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<SalesWeight> salesWeights) {

        
        try {
            service.save(salesWeights);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(SalesWeightView.All.class)
    public SalesWeight findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public SalesWeight updateCustomer(@PathVariable int id, @RequestBody SalesWeight salesWeight) {
        
        salesWeight.setId(id);
        salesWeight = service.save(salesWeight);
        return salesWeight;
    }

}
