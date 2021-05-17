package com.trendsmixed.fma.module.location;

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
@RequestMapping("/locations")
public class LocationController {

    
    private final LocationService service;

    @JsonView(LocationView.All.class)
    @GetMapping
    public Iterable< Location> findAll() {
        return service.findAll();
    }

    @JsonView(LocationView.All.class)
    @GetMapping("/page")
    Page< Location> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(LocationView.All.class)
    @PostMapping
    public Location save(@RequestBody Location location) {
        
        try {
            location = service.save(location);
            return location;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List< Location> locations) {

        
        try {
            for (Location location : locations) {
                location.setCode(location.getCode().trim());
                location.setName(location.getName().trim());
                Location existingLocation = service.findByCode(location.getCode());
                if (existingLocation != null) {
                    location.setId(existingLocation.getId());
                }
            }
            service.save(locations);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(LocationView.All.class)
    @GetMapping("/{id}")
    public Location findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public Location updateCustomer(@PathVariable int id, @RequestBody Location location) {
        
        location.setId(id);
        location = service.save(location);
        return location;
    }
}
