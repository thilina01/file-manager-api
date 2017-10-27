package com.trendsmixed.fma.module.labourcostperkg;

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
@RequestMapping("/labourCostPerKgs")
public class LabourCostPerKgController {

    private final AppSessionService appSessionService;
    private final LabourCostPerKgService service;

    @JsonView(LabourCostPerKgView.All.class)
    @GetMapping
    public Iterable<LabourCostPerKg> findAll() {
        return service.findAll();
    }

    @JsonView(LabourCostPerKgView.All.class)
    @GetMapping("/page")
    Page<LabourCostPerKg> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public LabourCostPerKg save(@RequestBody LabourCostPerKg labourCostPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            labourCostPerKg = service.save(labourCostPerKg);
            return labourCostPerKg;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<LabourCostPerKg> labourCostPerKgs, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(labourCostPerKgs);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(LabourCostPerKgView.All.class)
    public LabourCostPerKg findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public LabourCostPerKg updateCustomer(@PathVariable int id, @RequestBody LabourCostPerKg labourCostPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        labourCostPerKg.setId(id);
        labourCostPerKg = service.save(labourCostPerKg);
        return labourCostPerKg;
    }

}
