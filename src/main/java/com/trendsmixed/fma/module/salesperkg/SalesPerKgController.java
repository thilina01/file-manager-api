package com.trendsmixed.fma.module.salesperkg;

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
@RequestMapping("/salesPerKgs")
public class SalesPerKgController {

    private final AppSessionService appSessionService;
    private final SalesPerKgService service;

    @JsonView(SalesPerKgView.All.class)
    @GetMapping
    public Iterable<SalesPerKg> findAll() {
        return service.findAll();
    }

    @JsonView(SalesPerKgView.All.class)
    @GetMapping("/page")
    public Page<SalesPerKg> page(Pageable pageable) {
        return new Page(service.findAll(pageable));
    }

    @PostMapping
    public SalesPerKg save(@RequestBody SalesPerKg salesPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            salesPerKg = service.save(salesPerKg);
            return salesPerKg;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<SalesPerKg> salesPerKgs, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(salesPerKgs);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(SalesPerKgView.All.class)
    public SalesPerKg findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public SalesPerKg updateCustomer(@PathVariable int id, @RequestBody SalesPerKg salesPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        salesPerKg.setId(id);
        salesPerKg = service.save(salesPerKg);
        return salesPerKg;
    }

}
