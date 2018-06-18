package com.trendsmixed.fma.module.treatment;

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
@RequestMapping("/treatments")
public class TreatmentController {

    
    private final TreatmentService service;

    @JsonView(TreatmentView.All.class)
    @GetMapping
    public Iterable<Treatment> findAll() {
        return service.findAll();
    }

    @JsonView(TreatmentView.All.class)
    @GetMapping("/page")
    Page<Treatment> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(TreatmentView.All.class)
    @PostMapping
    public Treatment save(@RequestBody Treatment treatment) {
        
        try {
            treatment = service.save(treatment);
            return treatment;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(TreatmentView.All.class)
    @GetMapping("/{id}")
    public Treatment findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @JsonView(TreatmentView.All.class)
    @PutMapping("/{id}")
    public Treatment updateCustomer(@PathVariable int id, @RequestBody Treatment treatment) {
        
        treatment.setId(id);
        treatment = service.save(treatment);
        return treatment;
    }
}
