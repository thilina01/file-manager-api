package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.ControlPointRunLoss;
import com.trendsmixed.fma.jsonView.ControlPointRunLossView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.ControlPointRunLossService;
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
@RequestMapping("/controlPointRunLosss")
public class ControlPointRunLossController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ControlPointRunLossService controlPointRunLossService;

   
    @GetMapping
    public List<ControlPointRunLoss> findAll() {
        return controlPointRunLossService.findAll();
    }

    
    @PostMapping
    public ControlPointRunLoss save(@RequestBody ControlPointRunLoss controlPointRunLoss, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
//            List<ControlPointRunLossManpower> controlPointRunLossManpowers = controlPointRunLoss.getControlPointRunLossManpowerList();
//            for (ControlPointRunLossManpower controlPointRunLossManpower : controlPointRunLossManpowers) {
//                controlPointRunLossManpower.setControlPointRunLoss(controlPointRunLoss);                
//            }
//            
//            List<ControlPointRunLossJob> controlPointRunLossJobs = controlPointRunLoss.getControlPointRunLossJobList();
//            for (ControlPointRunLossJob controlPointRunLossJob : controlPointRunLossJobs) {
//                controlPointRunLossJob.setControlPointRunLoss(controlPointRunLoss);                
//            }
//            List<ControlPointRunLossLoss> controlPointRunLossLosses = controlPointRunLoss.getControlPointRunLossLossList();
//            for (ControlPointRunLossLoss controlPointRunLossLoss : controlPointRunLossLosses) {
//                controlPointRunLossLoss.setControlPointRunLoss(controlPointRunLoss);  
//                
//            }
            
            controlPointRunLoss = controlPointRunLossService.save(controlPointRunLoss);
            return controlPointRunLoss;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ControlPointRunLoss findOne(@PathVariable("id") int id) {
        return controlPointRunLossService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointRunLossService.delete(id);

    }

    @PutMapping("/{id}")
    public ControlPointRunLoss updateCustomer(@PathVariable int id, @RequestBody ControlPointRunLoss controlPointRunLoss, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointRunLoss.setId(id);
        controlPointRunLoss = controlPointRunLossService.save(controlPointRunLoss);
        return controlPointRunLoss;
    }

}
