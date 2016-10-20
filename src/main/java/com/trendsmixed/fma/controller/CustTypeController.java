package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.CustType;
import com.trendsmixed.fma.jsonView.CustTypeView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.CustTypeService;
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
@RequestMapping("/custTypes")
public class CustTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private CustTypeService custTypeService;

    @JsonView(CustTypeView.All.class)
    @GetMapping
    public List<CustType> findAll() {
        return custTypeService.findAll();
    }

    @JsonView(CustTypeView.All.class)
    @PostMapping
    public CustType save(@RequestBody CustType custType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            custType = custTypeService.save(custType);
            return custType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public CustType findOne(@PathVariable("id") int id) {
        return custTypeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable int id) {
        custTypeService.delete(id);
        return "Deleted";

    }

    @PutMapping("/{id}")
    public CustType updateCustomer(@PathVariable int id, @RequestBody CustType custType) {
        custType.setId(id);
        custType = custTypeService.save(custType);
        return custType;
    }

}
