package com.trendsmixed.fma.module.standardunit;

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
@RequestMapping("/standardUnits")
public class StandardUnitController {

    
    private final StandardUnitService service;

    @JsonView(StandardUnitView.All.class)
    @GetMapping
    public Iterable<StandardUnit> findAll() {
        return service.findAll();
    }

    @JsonView(StandardUnitView.All.class)
    @GetMapping("/page")
    Page<StandardUnit> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(StandardUnitView.All.class)
    @PostMapping
    public StandardUnit save(@RequestBody StandardUnit standardUnit,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {
            standardUnit = service.save(standardUnit);
            return standardUnit;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<StandardUnit> standardUnits,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {

            service.save(standardUnits);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(StandardUnitView.All.class)
    @GetMapping("/{id}")
    public StandardUnit findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.delete(id);
    }

    @JsonView(StandardUnitView.All.class)
    @PutMapping("/{id}")
    public StandardUnit updateCustomer(@PathVariable int id, @RequestBody StandardUnit standardUnit,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        standardUnit.setId(id);
        standardUnit = service.save(standardUnit);
        return standardUnit;
    }
}
