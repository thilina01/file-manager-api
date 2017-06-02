package com.trendsmixed.fma.module.absenteeism;

import com.trendsmixed.fma.module.labourturnover.*;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.Absenteeism;
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
@RequestMapping("/absenteeisms")
public class AbsenteeismController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private AbsenteeismService service;

    @JsonView(AbsenteeismView.AllAndLabourSource.class)
    @GetMapping
    public Iterable<Absenteeism> findAll() {
        return service.findAll();
    }

    @JsonView(AbsenteeismView.AllAndLabourSource.class)
    @GetMapping("/page")
    Page<Absenteeism> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public Absenteeism save(@RequestBody Absenteeism absenteeism, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            absenteeism = service.save(absenteeism);
            return absenteeism;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Absenteeism> absenteeisms, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(absenteeisms);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(AbsenteeismView.AllAndLabourSource.class)
    public Absenteeism findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public Absenteeism updateCustomer(@PathVariable int id, @RequestBody Absenteeism absenteeism, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        absenteeism.setId(id);
        absenteeism = service.save(absenteeism);
        return absenteeism;
    }

}
