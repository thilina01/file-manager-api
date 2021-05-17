package com.trendsmixed.fma.module.energyconsumption;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public EnergyConsumption save(@RequestBody EnergyConsumption energyConsumption) {
        
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
    public void saveMany(@RequestBody List< EnergyConsumption> energyConsumptions) {

        
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
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public EnergyConsumption updateCustomer(@PathVariable int id, @RequestBody EnergyConsumption energyConsumption) {
        
        energyConsumption.setId(id);
        energyConsumption = service.save(energyConsumption);
        return energyConsumption;
    }
}
