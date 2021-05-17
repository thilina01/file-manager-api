package com.trendsmixed.fma.module.designation;

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
@RequestMapping("/designations")
public class DesignationController {

    
    private final DesignationService service;

    @JsonView(DesignationView.All.class)
    @GetMapping
    public Iterable<Designation> findAll() {
        return service.findAll();
    }

    @JsonView(DesignationView.All.class)
    @GetMapping("/page")
    Page<Designation> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public Designation save(@RequestBody Designation designation,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {
            designation = service.save(designation);
            return designation;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Designation> designations,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {

            service.save(designations);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(DesignationView.All.class)
    @GetMapping("/{id}")
    public Designation findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public Designation updateCustomer(@PathVariable int id, @RequestBody Designation designation,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        designation.setId(id);
        designation = service.save(designation);
        return designation;
    }
}
