package com.trendsmixed.fma.module.shifttype;

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
@RequestMapping("/shiftTypes")
public class ShiftTypeController {

    
    private final ShiftTypeService service;

    @JsonView(ShiftTypeView.All.class)
    @GetMapping
    public Iterable<ShiftType> findAll() {
        return service.findAll();
    }

    @JsonView(ShiftTypeView.All.class)
    @GetMapping("/page")
    Page<ShiftType> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public ShiftType save(@RequestBody ShiftType shiftType,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {
            shiftType = service.save(shiftType);
            return shiftType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ShiftType> shiftTypes,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {

            service.save(shiftTypes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ShiftTypeView.All.class)
    @GetMapping("/{id}")
    public ShiftType findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public ShiftType updateCustomer(@PathVariable int id, @RequestBody ShiftType shiftType,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        shiftType.setId(id);
        shiftType = service.save(shiftType);
        return shiftType;
    }
}
