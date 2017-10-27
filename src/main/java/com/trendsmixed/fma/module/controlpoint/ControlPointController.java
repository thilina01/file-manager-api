package com.trendsmixed.fma.module.controlpoint;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.workcenter.WorkCenter;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.workcenter.WorkCenterService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/controlPoints")
public class ControlPointController {

    private final AppSessionService appSessionService;
    private final ControlPointService service;
    private WorkCenterService workCenterService;

    @JsonView(ControlPointView.AllAndControlPointTypeAllAndWorkCenterAllAndCostCenterAllAndSectionAll.class)
    @GetMapping
    public Iterable<ControlPoint> findAll() {
        return service.findAll();
    }

    @JsonView(ControlPointView.AllAndControlPointTypeAllAndWorkCenterAllAndCostCenterAllAndSectionAll.class)
    @GetMapping("/page")
    Page<ControlPoint> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(ControlPointView.AllAndWorkCenterAll.class)
    @PostMapping
    public ControlPoint save(@RequestBody ControlPoint controlPoint, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            controlPoint = service.save(controlPoint);
            return controlPoint;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ControlPoint> controlPoints, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            for (ControlPoint controlPoint : controlPoints) {
                controlPoint.setCode(controlPoint.getCode().trim());
                controlPoint.setName(controlPoint.getName().trim());
                ControlPoint existingControlPoint = service.findByCode(controlPoint.getCode());
                if (existingControlPoint != null) {
                    controlPoint.setId(existingControlPoint.getId());
                }
                WorkCenter workCenter = controlPoint.getWorkCenter();
                if (workCenter != null) {
                    workCenter = workCenterService.findByCode(workCenter.getCode());
                    controlPoint.setWorkCenter(workCenter);
                }
            }
            service.save(controlPoints);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ControlPointView.AllAndControlPointTypeAllAndWorkCenterAllAndCostCenterAllAndSectionAll.class)
    @GetMapping("/{id}")
    public ControlPoint findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public ControlPoint updateCustomer(@PathVariable int id, @RequestBody ControlPoint controlPoint, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPoint.setId(id);
        controlPoint = service.save(controlPoint);
        return controlPoint;
    }

}
