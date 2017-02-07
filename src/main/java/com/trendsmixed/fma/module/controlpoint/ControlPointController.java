package com.trendsmixed.fma.module.controlpoint;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.ControlPoint;
import com.trendsmixed.fma.entity.WorkCenter;
import com.trendsmixed.fma.module.controlpoint.ControlPointView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.controlpoint.ControlPointService;
import com.trendsmixed.fma.module.workcenter.WorkCenterService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/controlPoints")
public class ControlPointController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ControlPointService controlPointService;
    @Autowired
    private WorkCenterService workCenterService;

    @JsonView(ControlPointView.AllAndWorkCenterAllAndCostCenterAllAndSectionAll.class)
    @GetMapping
    public List<ControlPoint> findAll() {
        return controlPointService.findAll();
    }

    @JsonView(ControlPointView.AllAndWorkCenterAll.class)
    @PostMapping
    public ControlPoint save(@RequestBody ControlPoint controlPoint, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            controlPoint = controlPointService.save(controlPoint);
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
                ControlPoint existingControlPoint = controlPointService.findByCode(controlPoint.getCode());
                if (existingControlPoint != null) {
                    controlPoint.setId(existingControlPoint.getId());
                }
                WorkCenter workCenter = controlPoint.getWorkCenter();
                if (workCenter != null) {
                    workCenter = workCenterService.findByCode(workCenter.getCode());
                    controlPoint.setWorkCenter(workCenter);
                }
            }
            controlPointService.save(controlPoints);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ControlPoint findOne(@PathVariable("id") int id) {
        return controlPointService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointService.delete(id);

    }

    @PutMapping("/{id}")
    public ControlPoint updateCustomer(@PathVariable int id, @RequestBody ControlPoint controlPoint, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPoint.setId(id);
        controlPoint = controlPointService.save(controlPoint);
        return controlPoint;
    }

}
