package com.trendsmixed.fma.module.salesordertype;

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
@RequestMapping("/salesOrderTypes")
public class SalesOrderTypeController {

    
    private final SalesOrderTypeService service;

    @JsonView(SalesOrderTypeView.All.class)
    @GetMapping
    public Iterable<SalesOrderType> findAll() {
        return service.findAll();
    }

    @JsonView(SalesOrderTypeView.All.class)
    @GetMapping("/page")
    Page<SalesOrderType> page(Pageable pageable) {
        return new Page(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(SalesOrderTypeView.All.class)
    @PostMapping
    public SalesOrderType save(@RequestBody SalesOrderType salesOrderType) {
        
        try {
            salesOrderType = service.save(salesOrderType);
            return salesOrderType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public SalesOrderType findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public SalesOrderType updateCustomer(@PathVariable int id, @RequestBody SalesOrderType salesOrderType) {
        
        salesOrderType.setId(id);
        salesOrderType = service.save(salesOrderType);
        return salesOrderType;
    }
}
