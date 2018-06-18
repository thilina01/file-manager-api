package com.trendsmixed.fma.module.sectiontype;

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
@RequestMapping("/sectionTypes")
public class SectionTypeController {

    
    private final SectionTypeService service;

    @JsonView(SectionTypeView.All.class)
    @GetMapping
    public Iterable<SectionType> findAll() {
        return service.findAll();
    }

    @JsonView(SectionTypeView.All.class)
    @GetMapping("/page")
    Page<SectionType> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));

    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(SectionTypeView.All.class)
    @PostMapping
    public SectionType save(@RequestBody SectionType sectionType) {
        
        try {
            sectionType = service.save(sectionType);
            return sectionType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<SectionType> sectionTypes) {

        
        try {
            service.save(sectionTypes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public SectionType findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @PutMapping("/{id}")
    public SectionType updateCustomer(@PathVariable int id, @RequestBody SectionType sectionType) {
        
        sectionType.setId(id);
        sectionType = service.save(sectionType);
        return sectionType;
    }
}
