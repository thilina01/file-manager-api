package com.trendsmixed.fma.module.warehouse;

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
@RequestMapping("/warehouses")
public class WarehouseController {

    private final WarehouseService service;

    @LogExecution
    @JsonView(WarehouseView.All.class)
    @PostMapping
    public Warehouse save(@RequestBody Warehouse warehouse) {
        
        try {
            warehouse = service.save(warehouse);
            return warehouse;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @LogExecution
    @GetMapping
    @JsonView(WarehouseView.All.class)
    public Iterable<Warehouse> findAll() {
        return service.findAll();
    }

    @LogExecution
    @JsonView(WarehouseView.All.class)
    @GetMapping("/{id}")
    public Warehouse findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @LogExecution
    @JsonView(WarehouseView.All.class)
    @GetMapping("/page")
    Page<Warehouse> page(Pageable pageable) {
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
    public Warehouse update(@PathVariable int id, @RequestBody Warehouse warehouse) {
        
        warehouse.setId(id);
        warehouse = service.save(warehouse);
        return warehouse;
    }
}
