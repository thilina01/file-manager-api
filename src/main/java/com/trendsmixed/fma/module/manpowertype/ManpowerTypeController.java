package com.trendsmixed.fma.module.manpowertype;

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
@RequestMapping("/manpowerTypes")
public class ManpowerTypeController {

    
    private final ManpowerTypeService service;

    @JsonView(ManpowerTypeView.All.class)
    @GetMapping
    public Iterable<ManpowerType> findAll() {
        return service.findAll();
    }

    @JsonView(ManpowerTypeView.All.class)
    @GetMapping("/page")
    Page<ManpowerType> page(Pageable pageable) {
        return new Page<ManpowerType>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(ManpowerTypeView.All.class)
    @PostMapping
    public ManpowerType save(@RequestBody ManpowerType manpowerType) {
        
        try {
            manpowerType = service.save(manpowerType);
            return manpowerType;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ManpowerTypeView.All.class)
    @GetMapping("/{id}")
    public ManpowerType findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);
    }

    @JsonView(ManpowerTypeView.All.class)
    @PutMapping("/{id}")
    public ManpowerType updateCustomer(@PathVariable int id, @RequestBody ManpowerType manpowerType) {
        
        manpowerType.setId(id);
        manpowerType = service.save(manpowerType);
        return manpowerType;
    }
}
