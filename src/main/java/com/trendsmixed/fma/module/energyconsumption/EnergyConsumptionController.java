package com.trendsmixed.fma.module.energyconsumption;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/energyConsumptions")
public class EnergyConsumptionController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private EnergyConsumptionService service;

    @JsonView(EnergyConsumptionView.AllAndLocation.class)
    @GetMapping
    public Iterable< EnergyConsumption> findAll() {
        return service.findAll();
    }

    @JsonView(EnergyConsumptionView.AllAndLocation.class)
    @GetMapping("/page")
    Page< EnergyConsumption> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @JsonView(EnergyConsumptionView.All.class)
    @PostMapping
    public EnergyConsumption save(@RequestBody EnergyConsumption energyConsumption, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            energyConsumption = service.save(energyConsumption);
            return energyConsumption;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List< EnergyConsumption> energyConsumptions, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(energyConsumptions);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(EnergyConsumptionView.AllAndLocation.class)
    @GetMapping("/{id}")
    public EnergyConsumption findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public EnergyConsumption updateCustomer(@PathVariable int id, @RequestBody EnergyConsumption energyConsumption, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        energyConsumption.setId(id);
        energyConsumption = service.save(energyConsumption);
        return energyConsumption;
    }
}
