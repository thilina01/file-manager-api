package com.trendsmixed.fma.module.salesvalue;

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
@RequestMapping("/salesValues")
public class SalesValueController {

    private final AppSessionService appSessionService;
    private final SalesValueService service;

    @JsonView(SalesValueView.All.class)
    @GetMapping
    public Iterable<SalesValue> findAll() {
        return service.findAll();
    }

    @JsonView(SalesValueView.All.class)
    @GetMapping("/page")
    Page<SalesValue> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public SalesValue save(@RequestBody SalesValue salesValue, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            salesValue = service.save(salesValue);
            return salesValue;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<SalesValue> salesValues, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(salesValues);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(SalesValueView.All.class)
    public SalesValue findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public SalesValue updateCustomer(@PathVariable int id, @RequestBody SalesValue salesValue, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        salesValue.setId(id);
        salesValue = service.save(salesValue);
        return salesValue;
    }

}
