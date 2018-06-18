package com.trendsmixed.fma.module.labourcostperkg;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/labourCostPerKgs")
public class LabourCostPerKgController {

    
    private final LabourCostPerKgService service;

    @JsonView(LabourCostPerKgView.All.class)
    @GetMapping
    public Iterable<LabourCostPerKg> findAll() {
        return service.findAll();
    }

    @JsonView(LabourCostPerKgView.All.class)
    @GetMapping("/page")
    Page<LabourCostPerKg> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public LabourCostPerKg save(@RequestBody LabourCostPerKg labourCostPerKg) {

        
        try {
            labourCostPerKg = service.save(labourCostPerKg);
            return labourCostPerKg;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<LabourCostPerKg> labourCostPerKgs) {

        
        try {
            service.save(labourCostPerKgs);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(LabourCostPerKgView.All.class)
    public LabourCostPerKg findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @PutMapping("/{id}")
    public LabourCostPerKg updateCustomer(@PathVariable int id, @RequestBody LabourCostPerKg labourCostPerKg) {
        
        labourCostPerKg.setId(id);
        labourCostPerKg = service.save(labourCostPerKg);
        return labourCostPerKg;
    }

}
