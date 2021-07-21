package com.trendsmixed.fma.module.salesperson;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.log.LogExecution;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/salesPersons")
public class SalesPersonController {

    private final SalesPersonService service;

    @LogExecution
    @JsonView(SalesPersonView.All.class)
    @PostMapping
    public SalesPerson save(@RequestBody SalesPerson salesPerson) {
        
        try {
            salesPerson = service.save(salesPerson);
            return salesPerson;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @LogExecution
    @GetMapping
    @JsonView(SalesPersonView.All.class)
    public Iterable<SalesPerson> findAll() {
        return service.findAll();
    }

    @LogExecution
    @JsonView(SalesPersonView.All.class)
    @GetMapping("/{id}")
    public SalesPerson findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @LogExecution
    @JsonView(SalesPersonView.All.class)
    @GetMapping("/page")
    Page<SalesPerson> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @LogExecution
    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @LogExecution
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);
    }

    @LogExecution
    @PutMapping("/{id}")
    public SalesPerson update(@PathVariable int id, @RequestBody SalesPerson salesPerson) {
        
        salesPerson.setId(id);
        salesPerson = service.save(salesPerson);
        return salesPerson;
    }
}
