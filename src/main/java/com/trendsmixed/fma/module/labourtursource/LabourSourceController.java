package com.trendsmixed.fma.module.labourtursource;

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
@RequestMapping("/labourSources")
public class LabourSourceController {

    
    private final LabourSourceService service;

    @JsonView(LabourSourceView.All.class)
    @GetMapping
    public Iterable<LabourSource> findAll() {
        return service.findAll();
    }

    @JsonView(LabourSourceView.All.class)
    @GetMapping("/page")
    Page<LabourSource> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    @JsonView(LabourSourceView.All.class)
    public LabourSource save(@RequestBody LabourSource labourSource) {

        
        try {
            labourSource = service.save(labourSource);
            return labourSource;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<LabourSource> labourSources) {

        
        try {
            service.save(labourSources);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(LabourSourceView.All.class)
    public LabourSource findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    @JsonView(LabourSourceView.All.class)
    public LabourSource updateCustomer(@PathVariable int id, @RequestBody LabourSource labourSource) {
        
        labourSource.setId(id);
        labourSource = service.save(labourSource);
        return labourSource;
    }

}
