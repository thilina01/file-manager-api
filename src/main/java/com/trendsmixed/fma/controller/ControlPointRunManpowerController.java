package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.ControlPointRunManpower;
import com.trendsmixed.fma.jsonView.ControlPointRunManpowerView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.ControlPointRunManpowerService;
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
@RequestMapping("/controlPointRunManpowers")
public class ControlPointRunManpowerController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ControlPointRunManpowerService controlPointRunManpowerService;


    @GetMapping
    public List<ControlPointRunManpower> findAll() {
        return controlPointRunManpowerService.findAll();
    }

    
    @PostMapping
    public ControlPointRunManpower save(@RequestBody ControlPointRunManpower controlPointRunManpower, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {            
            controlPointRunManpower = controlPointRunManpowerService.save(controlPointRunManpower);
            return controlPointRunManpower;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ControlPointRunManpower findOne(@PathVariable("id") int id) {
        return controlPointRunManpowerService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointRunManpowerService.delete(id);

    }

    @PutMapping("/{id}")
    public ControlPointRunManpower updateCustomer(@PathVariable int id, @RequestBody ControlPointRunManpower controlPointRunManpower, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointRunManpower.setId(id);
        controlPointRunManpower = controlPointRunManpowerService.save(controlPointRunManpower);
        return controlPointRunManpower;
    }

}
