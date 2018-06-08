package com.trendsmixed.fma.module.subcontractor;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/subcontractors")
public class SubcontractorController {

    private final AppSessionService appSessionService;
    private final SubcontractorService service;
    @JsonView(SubcontractorView.All.class)
    @GetMapping
    public Iterable<Subcontractor> findAll() {
        return service.findAll();
    }

    @JsonView(SubcontractorView.All.class)
    @GetMapping("/page")
    Page<Subcontractor> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(SubcontractorView.All.class)
    @PostMapping
    public Subcontractor save(@RequestBody Subcontractor subcontractor, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
        
         return service.save(subcontractor);

        } 
        catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

     @JsonView(SubcontractorView.All.class)
    @GetMapping("/{id}")
    public Subcontractor findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Subcontractor> subcontractors, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SubcontractorView.All.class)
    @PutMapping("/{id}")
    public Subcontractor updateCustomer(@PathVariable int id, @RequestBody Subcontractor subcontractor, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        subcontractor.setId(id);
        subcontractor = service.save(subcontractor);
        return subcontractor;
    }

}
