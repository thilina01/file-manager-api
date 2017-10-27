package com.trendsmixed.fma.module.workcenter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.costcenter.CostCenter;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.costcenter.CostCenterService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/workCenters")
public class WorkCenterController {

    private final AppSessionService appSessionService;
    private final WorkCenterService service;
    private final CostCenterService costCenterService;

    @GetMapping
    @JsonView(WorkCenterView.AllAndCostCenterAll.class)
    public Iterable<WorkCenter> findAll() {
        return service.findAll();
    }

    @JsonView(WorkCenterView.All.class)
    @GetMapping("/page")
    Page<WorkCenter> page(Pageable pageable) {
        return new Page<WorkCenter>(service.findAll(pageable));
    }

    @JsonView(WorkCenterView.AllAndCostCenterAll.class)
    @PostMapping
    public WorkCenter save(@RequestBody WorkCenter workCenter,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            workCenter = service.save(workCenter);
            return workCenter;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<WorkCenter> workCenters,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            for (WorkCenter workCenter : workCenters) {
                workCenter.setCode(workCenter.getCode().trim());
                workCenter.setName(workCenter.getName().trim());
                WorkCenter existingWorkCenter = service.findByCode(workCenter.getCode());
                if (existingWorkCenter != null) {
                    workCenter.setId(existingWorkCenter.getId());
                }
                CostCenter costCenter = workCenter.getCostCenter();
                if (costCenter != null) {
                    costCenter = costCenterService.findByCode(costCenter.getCode());
                    workCenter.setCostCenter(costCenter);
                }
            }
            service.save(workCenters);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(WorkCenterView.AllAndCostCenterAll.class)
    @GetMapping("/{id}")
    public WorkCenter findOne(@PathVariable("id") int id, HttpServletRequest request) {
        String pattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
        System.out.println(pattern + " " + request.getMethod());
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    @JsonView(WorkCenterView.AllAndCostCenterAll.class)
    public WorkCenter updateCustomer(@PathVariable int id, @RequestBody WorkCenter workCenter,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        workCenter.setId(id);
        workCenter = service.save(workCenter);
        return workCenter;
    }

}
