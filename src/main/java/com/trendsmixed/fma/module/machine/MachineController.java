package com.trendsmixed.fma.module.machine;

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
@RequestMapping("/machines")
public class MachineController {

    
    private final MachineService service;

    @JsonView(MachineView.AllAndWorkCenterAll.class)
    @GetMapping
    public Iterable<Machine> findAll() {
        return service.findAll();
    }

    @JsonView(MachineView.AllAndWorkCenterAll.class)
    @GetMapping("/page")
    Page<Machine> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(MachineView.All.class)
    @PostMapping
    public Machine save(@RequestBody Machine machine) {
        
        try {
            machine = service.save(machine);
            return machine;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Machine> machines) {

        
        try {
            for (Machine machine : machines) {
                machine.setCode(machine.getCode().trim());
                machine.setName(machine.getName().trim());
                Machine existingMachine = service.findByCode(machine.getCode());
                if (existingMachine != null) {
                    machine.setId(existingMachine.getId());
                }
            }
            service.save(machines);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(MachineView.AllAndWorkCenterAll.class)
    @GetMapping("/{id}")
    public Machine findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public Machine updateCustomer(@PathVariable int id, @RequestBody Machine machine) {
        
        machine.setId(id);
        machine = service.save(machine);
        return machine;
    }
}
