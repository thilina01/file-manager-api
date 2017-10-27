package com.trendsmixed.fma.module.incoterm;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
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
@RequestMapping("/incoterms")
public class IncotermController {

    private final AppSessionService appSessionService;
    private final IncotermService service;

    @JsonView(IncotermView.All.class)
    @GetMapping
    public Iterable<Incoterm> findAll() {
        return service.findAll();
    }

    @JsonView(IncotermView.All.class)
    @GetMapping("/page")
    Page<Incoterm> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(IncotermView.All.class)
    @PostMapping
    public Incoterm save(@RequestBody Incoterm incoterm, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            incoterm = service.save(incoterm);
            return incoterm;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(IncotermView.All.class)
    @GetMapping("/{id}")
    public Incoterm findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(IncotermView.All.class)
    @PutMapping("/{id}")
    public Incoterm updateCustomer(@PathVariable int id, @RequestBody Incoterm incoterm, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        incoterm.setId(id);
        incoterm = service.save(incoterm);
        return incoterm;
    }
}
