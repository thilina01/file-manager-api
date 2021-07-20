package com.trendsmixed.fma.module.materialtype;

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
@RequestMapping("/materialTypes")
public class MaterialTypeController {

    
    private final MaterialTypeService service;

    @JsonView(MaterialTypeView.All.class)
    @GetMapping
    public Iterable<MaterialType> findAll() {
        return service.findAll();
    }

    @JsonView(MaterialTypeView.All.class)
    @GetMapping("/page")
    Page<MaterialType> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public MaterialType save(@RequestBody MaterialType materialType) {
        
        try {
            materialType = service.save(materialType);
            return materialType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(MaterialTypeView.All.class)
    @GetMapping("/{id}")
    public MaterialType findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public MaterialType updateCustomer(@PathVariable int id, @RequestBody MaterialType materialType) {
        
        materialType.setId(id);
        materialType = service.save(materialType);
        return materialType;
    }
}
