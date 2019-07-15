package com.trendsmixed.fma.module.rawmaterial;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/rawMaterials")
public class RawMaterialController {

    
    private final RawMaterialService service;

    @JsonView(RawMaterialView.All.class)
    @GetMapping
    public Iterable<RawMaterial> findAll() {
        return service.findAll();
    }

    @JsonView(RawMaterialView.All.class)
    @GetMapping("/page")
    Page<RawMaterial> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(RawMaterialView.All.class)
    @PostMapping
    public RawMaterial save(@RequestBody RawMaterial rawMaterial,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {
            rawMaterial = service.save(rawMaterial);
            return rawMaterial;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<RawMaterial> rawMaterials,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {

            service.save(rawMaterials);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(RawMaterialView.All.class)
    @GetMapping("/{id}")
    public RawMaterial findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.delete(id);
    }

    @JsonView(RawMaterialView.All.class)
    @PutMapping("/{id}")
    public RawMaterial updateCustomer(@PathVariable int id, @RequestBody RawMaterial rawMaterial,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        rawMaterial.setId(id);
        rawMaterial = service.save(rawMaterial);
        return rawMaterial;
    }
}
