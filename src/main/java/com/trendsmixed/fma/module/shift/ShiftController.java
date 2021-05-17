package com.trendsmixed.fma.module.shift;

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
@RequestMapping("/shifts")
public class ShiftController {

    private final ShiftService service;

    @LogExecution
    @JsonView(ShiftView.All.class)
    @PostMapping
    public Shift save(@RequestBody Shift shift) {
        
        try {
            shift = service.save(shift);
            return shift;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @LogExecution
    @GetMapping
    @JsonView(ShiftView.All.class)
    public Iterable<Shift> findAll() {
        return service.findAll();
    }

    @LogExecution
    @JsonView(ShiftView.All.class)
    @GetMapping("/{id}")
    public Shift findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @LogExecution
    @JsonView(ShiftView.All.class)
    @GetMapping("/page")
    Page<Shift> page(Pageable pageable) {
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
    public Shift update(@PathVariable int id, @RequestBody Shift shift) {
        
        shift.setId(id);
        shift = service.save(shift);
        return shift;
    }
}
