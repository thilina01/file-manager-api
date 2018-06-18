package com.trendsmixed.fma.module.manpower;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/manpowers")
public class ManpowerController {

    
    private final ManpowerService service;

    @JsonView(ManpowerView.AllManpowerTypeAllProductionAll.class)
    @GetMapping
    public Iterable<Manpower> findAll() {
        return service.findAll();
    }

    @JsonView(ManpowerView.AllManpowerTypeAllProductionAll.class)
    @GetMapping("/page")
    Page<Manpower> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @JsonView(ManpowerView.All.class)
    @PostMapping
    public Manpower save(@RequestBody Manpower manpower) {
        
        try {
            manpower = service.save(manpower);
            return manpower;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Manpower> manpowers) {

        
        try {
            service.save(manpowers);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Manpower findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @PutMapping("/{id}")
    public Manpower updateCustomer(@PathVariable int id, @RequestBody Manpower manpower) {
        
        manpower.setId(id);
        manpower = service.save(manpower);
        return manpower;
    }
}
