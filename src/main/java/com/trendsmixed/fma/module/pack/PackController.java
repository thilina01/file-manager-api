package com.trendsmixed.fma.module.pack;

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
@RequestMapping("/packs")
public class PackController {

    
    private final PackService service;

    @JsonView(PackView.All.class)
    @GetMapping
    public Iterable< Pack> findAll() {
        return service.findAll();
    }

    @JsonView(PackView.All.class)
    @GetMapping("/page")
    Page< Pack> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(PackView.All.class)
    @PostMapping
    public Pack save(@RequestBody Pack pack) {
        
        try {

            pack = service.save(pack);
            return pack;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List< Pack> packs) {
        
        try {
           
            service.save(packs);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(PackView.All.class)
    @GetMapping("/{id}")
    public Pack findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @PutMapping("/{id}")
    public Pack updateCustomer(@PathVariable int id, @RequestBody Pack pack) {
        
        pack.setId(id);
        pack = service.save(pack);
        return pack;
    }
}
