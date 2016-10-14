package com.trendsmixed.fma.controller;

import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.Machine;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.MachineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/machines")
public class MachineController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private MachineService machineService;

    @GetMapping
    public List<Machine> findAll() {
        return machineService.findAll();
    }

    @PostMapping
    public Machine save(@RequestBody Machine machine, @RequestHeader(value = "email", defaultValue = "") String email) {
        AppSession appSession = appSessionService.findOne(email);
        if (appSession == null) {
            throw new Error("Unauthorized access");
        } else {
            try {
                machine = machineService.save(machine);
                return machine;

            } catch (Throwable e) {
                while (e.getCause() != null) {
                    e = e.getCause();
                }
                throw new Error(e.getMessage());
            }
        }
    }

    @GetMapping("/{id}")
    public Machine findOne(@PathVariable("id") int id) {
        return machineService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable int id) {
        machineService.delete(id);
        return "Deleted";

    }

    @PutMapping("/{id}")
    public Machine updateCustomer(@PathVariable int id, @RequestBody Machine machine) {
        machine.setId(id);
        machine = machineService.save(machine);
        return machine;
    }
}
