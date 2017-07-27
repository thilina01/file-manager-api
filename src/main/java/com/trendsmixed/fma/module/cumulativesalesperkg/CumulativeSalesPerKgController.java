package com.trendsmixed.fma.module.cumulativesalesperkg;

import com.trendsmixed.fma.module.labourturnover.*;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.CumulativeSalesPerKg;
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
@RequestMapping("/cumulativeSalesPerKgs")
public class CumulativeSalesPerKgController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private CumulativeSalesPerKgService service;

    @JsonView(CumulativeSalesPerKgView.All.class)
    @GetMapping
    public Iterable<CumulativeSalesPerKg> findAll() {
        return service.findAll();
    }

    @JsonView(CumulativeSalesPerKgView.All.class)
    @GetMapping("/page")
    Page<CumulativeSalesPerKg> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public CumulativeSalesPerKg save(@RequestBody CumulativeSalesPerKg cumulativeSalesPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            cumulativeSalesPerKg = service.save(cumulativeSalesPerKg);
            return cumulativeSalesPerKg;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<CumulativeSalesPerKg> cumulativeSalesPerKgs, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(cumulativeSalesPerKgs);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(CumulativeSalesPerKgView.All.class)
    public CumulativeSalesPerKg findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public CumulativeSalesPerKg updateCustomer(@PathVariable int id, @RequestBody CumulativeSalesPerKg cumulativeSalesPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        cumulativeSalesPerKg.setId(id);
        cumulativeSalesPerKg = service.save(cumulativeSalesPerKg);
        return cumulativeSalesPerKg;
    }

}
