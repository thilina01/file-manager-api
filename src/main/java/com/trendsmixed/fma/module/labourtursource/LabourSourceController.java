package com.trendsmixed.fma.module.labourtursource;

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
@RequestMapping("/labourSources")
public class LabourSourceController {

    private final AppSessionService appSessionService;
    private final LabourSourceService service;

    @JsonView(LabourSourceView.All.class)
    @GetMapping
    public Iterable<LabourSource> findAll() {
        return service.findAll();
    }

    @JsonView(LabourSourceView.All.class)
    @GetMapping("/page")
    Page<LabourSource> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    @JsonView(LabourSourceView.All.class)
    public LabourSource save(@RequestBody LabourSource labourSource, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            labourSource = service.save(labourSource);
            return labourSource;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<LabourSource> labourSources, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(labourSources);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(LabourSourceView.All.class)
    public LabourSource findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    @JsonView(LabourSourceView.All.class)
    public LabourSource updateCustomer(@PathVariable int id, @RequestBody LabourSource labourSource, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        labourSource.setId(id);
        labourSource = service.save(labourSource);
        return labourSource;
    }

}
