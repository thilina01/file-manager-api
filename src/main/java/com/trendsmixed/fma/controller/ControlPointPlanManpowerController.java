package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.ControlPointPlanManpower;
import com.trendsmixed.fma.jsonView.ControlPointPlanManpowerView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.ControlPointPlanManpowerService;
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
@RequestMapping("/controlPointPlanManpowers")
public class ControlPointPlanManpowerController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ControlPointPlanManpowerService controlPointPlanManpowerService;
   
    @JsonView(ControlPointPlanManpowerView.AllAndManpowerTypeAllAndControlPointPlanAll.class)
    @GetMapping
    public List<ControlPointPlanManpower> findAll() {
        return controlPointPlanManpowerService.findAll();
    }


    @PostMapping
    public ControlPointPlanManpower save(@RequestBody ControlPointPlanManpower controlPointPlanManpower, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            controlPointPlanManpower = controlPointPlanManpowerService.save(controlPointPlanManpower);
            return controlPointPlanManpower;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ControlPointPlanManpower findOne(@PathVariable("id") int id) {
        return controlPointPlanManpowerService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointPlanManpowerService.delete(id);

    }

    @PutMapping("/{id}")
    public ControlPointPlanManpower updateCustomer(@PathVariable int id, @RequestBody ControlPointPlanManpower controlPointPlanManpower, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointPlanManpower.setId(id);
        controlPointPlanManpower = controlPointPlanManpowerService.save(controlPointPlanManpower);
        return controlPointPlanManpower;
    }

}
