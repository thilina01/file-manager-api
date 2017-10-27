package com.trendsmixed.fma.module.controlpointmachine;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/controlPointMachines")
public class ControlPointMachineController {

    private final AppSessionService appSessionService;
    private final ControlPointMachineService service;

    @JsonView(ControlPointMachineView.IdAndControlPointAndMachine.class)
    @GetMapping
    public Iterable<ControlPointMachine> findAll() {
        return service.findAll();
    }

    @JsonView(ControlPointMachineView.IdAndControlPointAndMachine.class)
    @GetMapping("/page")
    Page<ControlPointMachine> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @JsonView(ControlPointMachineView.IdAndControlPointAndMachine.class)
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

    @JsonView(ControlPointMachineView.IdAndControlPointAndMachine.class)
    @GetMapping("/{id}")
    public ControlPointMachine findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(ControlPointMachineView.IdAndControlPointAndMachine.class)
    @PutMapping("/{id}")
    public ControlPointMachine updateCustomer(@PathVariable int id, @RequestBody ControlPointMachine controlPointMachine, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointMachine.setId(id);
        controlPointMachine = service.save(controlPointMachine);
        return controlPointMachine;
    }
}
