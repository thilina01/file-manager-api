package com.trendsmixed.fma.module.controlpointmachine;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.ControlPointMachine;
import com.trendsmixed.fma.entity.Machine;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.machine.MachineView;
import com.trendsmixed.fma.utility.Page;

@RestController
@CrossOrigin
@RequestMapping("/controlPointMachines")
public class ControlPointMachineController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ControlPointMachineService service;

    @JsonView(ControlPointMachineView.ControlPointAndMachine.class)
    @GetMapping
    public Iterable<ControlPointMachine> findAll() {
        return service.findAll();
    }

    @JsonView(ControlPointMachineView.ControlPointAndMachine.class)
    @GetMapping("/page")
	Page<ControlPointMachine> page( Pageable pageable){
    	return service.findAll(pageable);
	} 
    
    @JsonView(ControlPointMachineView.ControlPointAndMachine.class)
    @PostMapping
    public ControlPointMachine save(@RequestBody ControlPointMachine controlPointMachine, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            ControlPointMachine existingMachine = service.findByControlPointAndMachine(controlPointMachine.getControlPoint(), controlPointMachine.getMachine());
            if (existingMachine != null) {
                controlPointMachine.setId(existingMachine.getId());
            } 
            controlPointMachine = service.save(controlPointMachine);
            return controlPointMachine;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ControlPointMachine> controlPointMachines, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {                        
            for (ControlPointMachine controlPointMachine : controlPointMachines) {              
                ControlPointMachine existingMachine = service.findByControlPointAndMachine(controlPointMachine.getControlPoint(), controlPointMachine.getMachine());
                if (existingMachine != null) {
                    controlPointMachine.setId(existingMachine.getId());
                }                
            }
            service.save(controlPointMachines);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ControlPointMachineView.ControlPointAndMachine.class)
    @GetMapping("/{id}")
    public ControlPointMachine findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(ControlPointMachineView.ControlPointAndMachine.class)
    @PutMapping("/{id}")
    public ControlPointMachine updateCustomer(@PathVariable int id, @RequestBody ControlPointMachine controlPointMachine, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointMachine.setId(id);
        controlPointMachine = service.save(controlPointMachine);
        return controlPointMachine;
    }
}
