package com.trendsmixed.fma.module.consumablecostperkg;

import com.trendsmixed.fma.module.labourturnover.*;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.ConsumableCostPerKg;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/consumableCostPerKgs")
public class ConsumableCostPerKgController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ConsumableCostPerKgService service;

    @JsonView(ConsumableCostPerKgView.All.class)
    @GetMapping
    public Iterable<ConsumableCostPerKg> findAll() {
        return service.findAll();
    }

    @JsonView(ConsumableCostPerKgView.All.class)
    @GetMapping("/page")
    Page<ConsumableCostPerKg> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public ConsumableCostPerKg save(@RequestBody ConsumableCostPerKg consumableCostPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            consumableCostPerKg = service.save(consumableCostPerKg);
            return consumableCostPerKg;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ConsumableCostPerKg> consumableCostPerKgs, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(consumableCostPerKgs);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(ConsumableCostPerKgView.All.class)
    public ConsumableCostPerKg findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public ConsumableCostPerKg updateCustomer(@PathVariable int id, @RequestBody ConsumableCostPerKg consumableCostPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        consumableCostPerKg.setId(id);
        consumableCostPerKg = service.save(consumableCostPerKg);
        return consumableCostPerKg;
    }

}
