package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.DownTime;
import com.trendsmixed.fma.jsonView.DownTimeView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.DownTimeService;
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
@RequestMapping("/downTimes")
public class DownTimeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private DownTimeService downTimeTypeService;

    @JsonView(DownTimeView.AllAndMachineAll.class)
    @GetMapping
    public List<DownTime> findAll() {
        return downTimeTypeService.findAll();
    }

    @JsonView(DownTimeView.AllAndMachineAll.class)
    @PostMapping
    public DownTime save(@RequestBody DownTime downTimeType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        AppSession appSession = appSessionService.findOne(email);
        if (appSession == null) {
            throw new Error("Unauthorized access");
        } else {
            try {
                downTimeType = downTimeTypeService.save(downTimeType);
                return downTimeType;

            } catch (Throwable e) {
                while (e.getCause() != null) {
                    e = e.getCause();
                }
                throw new Error(e.getMessage());
            }
        }
    }

    @GetMapping("/{id}")
    public DownTime findOne(@PathVariable("id") int id) {
        return downTimeTypeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable int id) {
        downTimeTypeService.delete(id);
        return "Deleted";

    }

    @PutMapping("/{id}")
    public DownTime updateCustomer(@PathVariable int id, @RequestBody DownTime downTimeType) {
        downTimeType.setId(id);
        downTimeType = downTimeTypeService.save(downTimeType);
        return downTimeType;
    }
}
