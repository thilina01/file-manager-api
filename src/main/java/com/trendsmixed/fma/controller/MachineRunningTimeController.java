package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.MachineRunningTime;
import com.trendsmixed.fma.jsonView.MachineRunningTimeView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.MachineRunningTimeService;
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
@RequestMapping("/machineRunningTimes")
public class MachineRunningTimeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private MachineRunningTimeService machineRunningTimeService;

    @JsonView(MachineRunningTimeView.AllAndMachineAll.class)
    @PostMapping
    public MachineRunningTime save(@RequestBody MachineRunningTime machineRunningTime, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        AppSession appSession = appSessionService.findOne(email);
        if (appSession == null) {
            throw new Error("Unauthorized access");
        } else {
            try {
                machineRunningTime = machineRunningTimeService.save(machineRunningTime);
                return machineRunningTime;

            } catch (Throwable e) {
                while (e.getCause() != null) {
                    e = e.getCause();
                }
                throw new Error(e.getMessage());
            }
        }
    }

    @JsonView(MachineRunningTimeView.AllAndMachineAll.class)
    @GetMapping
    public List<MachineRunningTime> findAll() {
        return machineRunningTimeService.findAll();
    }

    @GetMapping("/{id}")
    public MachineRunningTime findOne(@PathVariable("id") int id) {
        return machineRunningTimeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable int id) {
        machineRunningTimeService.delete(id);
        return "Deleted";

    }

    @PutMapping("/{id}")
    public MachineRunningTime updateCustomer(@PathVariable int id, @RequestBody MachineRunningTime machineRunningTime) {
        machineRunningTime.setId(id);
        machineRunningTime = machineRunningTimeService.save(machineRunningTime);
        return machineRunningTime;
    }
}
