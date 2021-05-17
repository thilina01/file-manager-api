package com.trendsmixed.fma.module.controlpoint;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.log.LogExecution;
import com.trendsmixed.fma.module.workcenter.WorkCenter;
import com.trendsmixed.fma.module.workcenter.WorkCenterService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/controlPoints")
public class ControlPointController {
    
    private final ControlPointService service;
    private WorkCenterService workCenterService;

    @LogExecution
    @JsonView(ControlPointView.AllAndControlPointTypeAllAndWorkCenterAllAndCostCenterAllAndSectionAll.class)
    @GetMapping
    public Iterable<ControlPoint> findAll() {
        return service.findAll();
    }

    @LogExecution
    @JsonView(ControlPointView.AllAndControlPointTypeAllAndWorkCenterAllAndCostCenterAllAndSectionAll.class)
    @GetMapping("/page")
    Page<ControlPoint> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @LogExecution
    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @LogExecution
    @JsonView(ControlPointView.AllAndWorkCenterAll.class)
    @PostMapping
    public ControlPoint save(@RequestBody ControlPoint controlPoint) {
        
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

    @LogExecution
    @PostMapping("/many")
    public void saveMany(@RequestBody List<ControlPoint> controlPoints) {
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

    @LogExecution
    @JsonView(ControlPointView.AllAndControlPointTypeAllAndWorkCenterAllAndCostCenterAllAndSectionAll.class)
    @GetMapping("/{id}")
    public ControlPoint findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @LogExecution
    @PutMapping("/{id}")
    public ControlPoint updateCustomer(@PathVariable int id, @RequestBody ControlPoint controlPoint) {
        
        controlPoint.setId(id);
        controlPoint = service.save(controlPoint);
        return controlPoint;
    }

}
