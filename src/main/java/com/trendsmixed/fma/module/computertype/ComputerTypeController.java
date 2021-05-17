package com.trendsmixed.fma.module.computertype;

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
@RequestMapping("/computerTypes")
public class ComputerTypeController {

    
    private final ComputerTypeService service;

    @JsonView(ComputerTypeView.All.class)
    @GetMapping
    public Iterable<ComputerType> findAll() {
        return service.findAll();
    }

    @JsonView(ComputerTypeView.All.class)
    @GetMapping("/page")
    Page<ComputerType> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(ComputerTypeView.All.class)
    @PostMapping
    public ComputerType save(@RequestBody ComputerType computerType,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {
            computerType = service.save(computerType);
            return computerType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ComputerType> computerTypes,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {

            service.save(computerTypes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ComputerTypeView.All.class)
    @GetMapping("/{id}")
    public ComputerType findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.deleteById(id);
    }

    @JsonView(ComputerTypeView.All.class)
    @PutMapping("/{id}")
    public ComputerType updateCustomer(@PathVariable int id, @RequestBody ComputerType computerType,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        computerType.setId(id);
        computerType = service.save(computerType);
        return computerType;
    }
}
