package com.trendsmixed.fma.module.machine;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/machines")
public class MachineController {

    private final AppSessionService appSessionService;
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
    public Machine save(@RequestBody Machine machine, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
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
    public void saveMany(@RequestBody List<Machine> machines, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
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
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public Machine updateCustomer(@PathVariable int id, @RequestBody Machine machine, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        machine.setId(id);
        machine = service.save(machine);
        return machine;
    }
}
