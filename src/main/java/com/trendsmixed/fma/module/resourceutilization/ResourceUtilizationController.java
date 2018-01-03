package com.trendsmixed.fma.module.resourceutilization;

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
@RequestMapping("/resourceUtilizations")
public class ResourceUtilizationController {

    private final AppSessionService appSessionService;
    private final ResourceUtilizationService service;

    @GetMapping
    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAll.class)
    public Iterable<ResourceUtilization> findAll() {
        return service.findAll();
    }

    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAll.class)
    @GetMapping("/page")
    Page<ResourceUtilization> page(Pageable pageable) {
        return new Page<ResourceUtilization>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAll.class)
    public ResourceUtilization save(@RequestBody ResourceUtilization resourceUtilization, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            resourceUtilization = service.save(resourceUtilization);
            return resourceUtilization;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ResourceUtilization> resourceUtilizations, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(resourceUtilizations);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAll.class)
    @GetMapping("/{id}")
    public ResourceUtilization findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);

    }

    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAll.class)
    @PutMapping("/{id}")
    public ResourceUtilization updateCustomer(@PathVariable int id, @RequestBody ResourceUtilization resourceUtilization) {
        resourceUtilization.setId(id);
        resourceUtilization = service.save(resourceUtilization);
        return resourceUtilization;
    }

}
