package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.ControlPoint;
import com.trendsmixed.fma.entity.ControlPointRun;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.ControlPointRunJob;
import com.trendsmixed.fma.entity.Shift;
import com.trendsmixed.fma.jsonView.ControlPointRunJobView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.ControlPointRunJobService;
import com.trendsmixed.fma.service.ControlPointRunService;
import com.trendsmixed.fma.service.ControlPointService;
import com.trendsmixed.fma.service.ShiftService;
import java.util.ArrayList;
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
@RequestMapping("/controlPointRunJobs")
public class ControlPointRunJobController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ControlPointRunJobService controlPointRunJobService;
    @Autowired
    private ControlPointRunService controlPointRunService;
    @Autowired
    private ControlPointService controlPointService;
    @Autowired
    private ShiftService shiftService;

    @JsonView(ControlPointRunJobView.AllAndJobAndJobTypeAndControlPointRun.class)
    @GetMapping
    public List<ControlPointRunJob> findAll() {
        return controlPointRunJobService.findAll();
    }

    @PostMapping
    public ControlPointRunJob save(@RequestBody ControlPointRunJob controlPointRunJob, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
//            List<ControlPointRunJobManpower> controlPointRunJobManpowers = controlPointRunJob.getControlPointRunJobManpowerList();
//            for (ControlPointRunJobManpower controlPointRunJobManpower : controlPointRunJobManpowers) {
//                controlPointRunJobManpower.setControlPointRunJob(controlPointRunJob);                
//            }
//            
//            List<ControlPointRunJobJob> controlPointRunJobJobs = controlPointRunJob.getControlPointRunJobJobList();
//            for (ControlPointRunJobJob controlPointRunJobJob : controlPointRunJobJobs) {
//                controlPointRunJobJob.setControlPointRunJob(controlPointRunJob);                
//            }
//            List<ControlPointRunJobLoss> controlPointRunJobLosses = controlPointRunJob.getControlPointRunJobLossList();
//            for (ControlPointRunJobLoss controlPointRunJobLoss : controlPointRunJobLosses) {
//                controlPointRunJobLoss.setControlPointRunJob(controlPointRunJob);  
//                
//            }

            controlPointRunJob = controlPointRunJobService.save(controlPointRunJob);
            return controlPointRunJob;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ControlPointRunJob> controlPointRunJobs, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            List<ControlPointRunJob> controlPointRunJobsToSave = new ArrayList<>();
            for (ControlPointRunJob controlPointRunJob : controlPointRunJobs) {
                ControlPointRun controlPointRun = controlPointRunJob.getControlPointRun();
                if (controlPointRun != null) {
                    ControlPoint controlPoint = controlPointRun.getControlPoint();
                    controlPoint = controlPointService.findByCode(controlPoint.getCode());
                    Shift shift = controlPointRun.getShift();
                    shift = shiftService.findByCode(shift.getCode());
                    if (controlPoint != null && shift != null) {
                        controlPointRun = controlPointRunService.findByRunDateAndControlPointAndShift(controlPointRun.getRunDate(), controlPoint, shift);
                        controlPointRunJob.setControlPointRun(controlPointRun);
                        controlPointRunJobsToSave.add(controlPointRunJob);
                    }
                }
            }
            controlPointRunJobService.save(controlPointRunJobsToSave);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ControlPointRunJob findOne(@PathVariable("id") int id) {
        return controlPointRunJobService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointRunJobService.delete(id);
    }

    @PutMapping("/{id}")
    public ControlPointRunJob updateCustomer(@PathVariable int id, @RequestBody ControlPointRunJob controlPointRunJob, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointRunJob.setId(id);
        controlPointRunJob = controlPointRunJobService.save(controlPointRunJob);
        return controlPointRunJob;
    }

}
