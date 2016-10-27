package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.Machine;
import com.trendsmixed.fma.jsonView.MachineView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.MachineService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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

    @JsonView(MachineView.AllAndWorkCenterAll.class)
    @GetMapping
    public List<Machine> findAll() {
        return machineService.findAll();
    }

    @JsonView(MachineView.All.class)
    @PostMapping
    public Machine save(@RequestBody Machine machine, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
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

    @GetMapping("/{id}")
    public Machine findOne(@PathVariable("id") int id) {
        return machineService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        machineService.delete(id);

    }

    @PutMapping("/{id}")
    public Machine updateCustomer(@PathVariable int id, @RequestBody Machine machine, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        machine.setId(id);
        machine = machineService.save(machine);
        return machine;
    }
}
