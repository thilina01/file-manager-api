package com.trendsmixed.fma.module.accidenttype;

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
@RequestMapping("/accidentTypes")
public class AccidentTypeController {

    
    private final AccidentTypeService service;

    @JsonView(AccidentTypeView.All.class)
    @GetMapping
    public Iterable<AccidentType> findAll() {
        return service.findAll();
    }

    @JsonView(AccidentTypeView.All.class)
    @GetMapping("/page")
    Page<AccidentType> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(AccidentTypeView.All.class)
    @PostMapping
    public AccidentType save(@RequestBody AccidentType accidentType,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {
            accidentType = service.save(accidentType);
            return accidentType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<AccidentType> accidentTypes,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {

            service.save(accidentTypes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(AccidentTypeView.All.class)
    @GetMapping("/{id}")
    public AccidentType findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.deleteById(id);
    }

    @JsonView(AccidentTypeView.All.class)
    @PutMapping("/{id}")
    public AccidentType updateCustomer(@PathVariable int id, @RequestBody AccidentType accidentType,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        accidentType.setId(id);
        accidentType = service.save(accidentType);
        return accidentType;
    }
}
