package com.trendsmixed.fma.module.consumablecostperkg;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/consumableCostPerKgs")
public class ConsumableCostPerKgController {

    
    private final ConsumableCostPerKgService service;

    @JsonView(ConsumableCostPerKgView.All.class)
    @GetMapping
    public Iterable<ConsumableCostPerKg> findAll() {
        return service.findAll();
    }

    @JsonView(ConsumableCostPerKgView.All.class)
    @GetMapping("/page")
    Page<ConsumableCostPerKg> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public ConsumableCostPerKg save(@RequestBody ConsumableCostPerKg consumableCostPerKg) {

        
        try {
            consumableCostPerKg = service.save(consumableCostPerKg);
            return consumableCostPerKg;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ConsumableCostPerKg> consumableCostPerKgs) {

        
        try {
            service.save(consumableCostPerKgs);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(ConsumableCostPerKgView.All.class)
    public ConsumableCostPerKg findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public ConsumableCostPerKg updateCustomer(@PathVariable int id, @RequestBody ConsumableCostPerKg consumableCostPerKg) {
        
        consumableCostPerKg.setId(id);
        consumableCostPerKg = service.save(consumableCostPerKg);
        return consumableCostPerKg;
    }

}
