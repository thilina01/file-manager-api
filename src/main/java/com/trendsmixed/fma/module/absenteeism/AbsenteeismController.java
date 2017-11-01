package com.trendsmixed.fma.module.absenteeism;

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
@RequestMapping("/absenteeisms")
public class AbsenteeismController {

    private final AppSessionService appSessionService;
    private final AbsenteeismService service;

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
