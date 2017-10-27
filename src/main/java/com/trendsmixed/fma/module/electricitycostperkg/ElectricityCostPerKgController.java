package com.trendsmixed.fma.module.electricitycostperkg;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/electricityCostPerKgs")
public class ElectricityCostPerKgController {

    private final AppSessionService appSessionService;
    private final ElectricityCostPerKgService service;

    @JsonView(ElectricityCostPerKgView.All.class)
    @GetMapping
    public Iterable<ElectricityCostPerKg> findAll() {
        return service.findAll();
    }

    @JsonView(ElectricityCostPerKgView.All.class)
    @GetMapping("/page")
    Page<ElectricityCostPerKg> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public ElectricityCostPerKg save(@RequestBody ElectricityCostPerKg electricityCostPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            electricityCostPerKg = service.save(electricityCostPerKg);
            return electricityCostPerKg;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ElectricityCostPerKg> electricityCostPerKgs, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(electricityCostPerKgs);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(ElectricityCostPerKgView.All.class)
    public ElectricityCostPerKg findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public ElectricityCostPerKg updateCustomer(@PathVariable int id, @RequestBody ElectricityCostPerKg electricityCostPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        electricityCostPerKg.setId(id);
        electricityCostPerKg = service.save(electricityCostPerKg);
        return electricityCostPerKg;
    }

}
