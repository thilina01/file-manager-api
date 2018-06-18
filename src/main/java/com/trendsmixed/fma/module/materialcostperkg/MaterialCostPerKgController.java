package com.trendsmixed.fma.module.materialcostperkg;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/materialCostPerKgs")
public class MaterialCostPerKgController {

    
    private final MaterialCostPerKgService service;

    @JsonView(MaterialCostPerKgView.All.class)
    @GetMapping
    public Iterable<MaterialCostPerKg> findAll() {
        return service.findAll();
    }

    @JsonView(MaterialCostPerKgView.All.class)
    @GetMapping("/page")
    Page<MaterialCostPerKg> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public MaterialCostPerKg save(@RequestBody MaterialCostPerKg materialCostPerKg) {

        
        try {
            materialCostPerKg = service.save(materialCostPerKg);
            return materialCostPerKg;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<MaterialCostPerKg> materialCostPerKgs) {

        
        try {
            service.save(materialCostPerKgs);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(MaterialCostPerKgView.All.class)
    public MaterialCostPerKg findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @PutMapping("/{id}")
    public MaterialCostPerKg updateCustomer(@PathVariable int id, @RequestBody MaterialCostPerKg materialCostPerKg) {
        
        materialCostPerKg.setId(id);
        materialCostPerKg = service.save(materialCostPerKg);
        return materialCostPerKg;
    }

}
