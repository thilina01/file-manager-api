package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.ControlPoint;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.ControlPointRun;
import com.trendsmixed.fma.entity.ControlPointRunBreakdown;
import com.trendsmixed.fma.entity.ControlPointRunJob;
import com.trendsmixed.fma.entity.ControlPointRunLoss;
import com.trendsmixed.fma.entity.ControlPointRunManpower;
import com.trendsmixed.fma.entity.Shift;
import com.trendsmixed.fma.jsonView.ControlPointRunView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.ControlPointRunService;
import com.trendsmixed.fma.service.ControlPointService;
import com.trendsmixed.fma.service.ShiftService;
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
@RequestMapping("/controlPointRuns")
public class ControlPointRunController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ControlPointRunService controlPointRunService;
    @Autowired
    private ControlPointService controlPointService;
    @Autowired
    private ShiftService shiftService;

    @JsonView(ControlPointRunView.AllAndShiftAndControllPoint.class)
    @GetMapping
    public List<ControlPointRun> findAll() {
        return controlPointRunService.findAll();
    }

    @JsonView(ControlPointRunView.AllAndShiftAndControllPoint.class)
    @PostMapping
    public ControlPointRun save(@RequestBody ControlPointRun controlPointRun, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            List<ControlPointRunManpower> controlPointRunManpowers = controlPointRun.getControlPointRunManpowerList();
            if (controlPointRunManpowers != null) {
                for (ControlPointRunManpower controlPointRunManpower : controlPointRunManpowers) {
                    controlPointRunManpower.setControlPointRun(controlPointRun);
                }
            }

            List<ControlPointRunJob> controlPointRunJobs = controlPointRun.getControlPointRunJobList();
            if (controlPointRunJobs != null) {
                for (ControlPointRunJob controlPointRunJob : controlPointRunJobs) {
                    controlPointRunJob.setControlPointRun(controlPointRun);
                }
            }

            List<ControlPointRunLoss> controlPointRunLosses = controlPointRun.getControlPointRunLossList();
            if (controlPointRunLosses != null) {
                for (ControlPointRunLoss controlPointRunLoss : controlPointRunLosses) {
                    controlPointRunLoss.setControlPointRun(controlPointRun);
                }
            }

            List<ControlPointRunBreakdown> controlPointRunBreakdowns = controlPointRun.getControlPointRunBreakdownList();
            if (controlPointRunBreakdowns != null) {
                for (ControlPointRunBreakdown controlPointRunBreakdown : controlPointRunBreakdowns) {
                    controlPointRunBreakdown.setControlPointRun(controlPointRun);
                }
            }

            controlPointRun = controlPointRunService.save(controlPointRun);
            return controlPointRun;

        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ControlPointRun> controlPointRuns, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            for (ControlPointRun controlPointRun : controlPointRuns) {
                Shift shift = controlPointRun.getShift();
                if (shift != null) {
                    shift = shiftService.findByCode(shift.getCode());
                    controlPointRun.setShift(shift);
                }
                ControlPoint controlPoint = controlPointRun.getControlPoint();
                if (controlPoint != null) {
                    controlPoint = controlPointService.findByCode(controlPoint.getCode());
                    controlPointRun.setControlPoint(controlPoint);
                }
                ControlPointRun existingControlPointRun = controlPointRunService.findByRunDateAndControlPointAndShift(controlPointRun.getRunDate(),controlPoint,shift);
                if (existingControlPointRun != null) {
                    controlPointRun.setId(existingControlPointRun.getId());
                }
            }
            controlPointRunService.save(controlPointRuns);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ControlPointRun findOne(@PathVariable("id") int id) {
        return controlPointRunService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointRunService.delete(id);

    }

    @PutMapping("/{id}")
    public ControlPointRun updateCustomer(@PathVariable int id, @RequestBody ControlPointRun controlPointRun, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointRun.setId(id);
        controlPointRun = controlPointRunService.save(controlPointRun);
        return controlPointRun;
    }

}
