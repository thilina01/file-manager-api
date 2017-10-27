package com.trendsmixed.fma.module.salesweight;

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
@RequestMapping("/salesWeights")
public class SalesWeightController {

    private final AppSessionService appSessionService;
    private final SalesWeightService service;

    @JsonView(SalesWeightView.All.class)
    @GetMapping
    public Iterable<SalesWeight> findAll() {
        return service.findAll();
    }

    @JsonView(SalesWeightView.All.class)
    @GetMapping("/page")
    Page<SalesWeight> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public SalesWeight save(@RequestBody SalesWeight salesWeight, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            salesWeight = service.save(salesWeight);
            return salesWeight;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<SalesWeight> salesWeights, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(salesWeights);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(SalesWeightView.All.class)
    public SalesWeight findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public SalesWeight updateCustomer(@PathVariable int id, @RequestBody SalesWeight salesWeight, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        salesWeight.setId(id);
        salesWeight = service.save(salesWeight);
        return salesWeight;
    }

}
