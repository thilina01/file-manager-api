package com.trendsmixed.fma.module.application;

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
@RequestMapping("/applications")
public class ApplicationController {

    
    private final ApplicationService service;

    @JsonView(ApplicationView.All.class)
    @GetMapping
    public Iterable<Application> findAll() {
        return service.findAll();
    }

    @JsonView(ApplicationView.All.class)
    @GetMapping("/page")
    Page<Application> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(ApplicationView.All.class)
    @PostMapping
    public Application save(@RequestBody Application application) {
        
        try {
            application = service.save(application);
            return application;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ApplicationView.All.class)
    @GetMapping("/{id}")
    public Application findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @JsonView(ApplicationView.All.class)
    @PutMapping("/{id}")
    public Application updateCustomer(@PathVariable int id, @RequestBody Application application) {
        
        application.setId(id);
        application = service.save(application);
        return application;
    }
}
