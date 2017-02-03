package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.Operation;
import com.trendsmixed.fma.jsonView.OperationView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.OperationService;
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
@RequestMapping("/operations")
public class OperationController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private OperationService operationService;

    @JsonView(OperationView.All.class)
    @GetMapping
    public List<Operation> findAll() {
        return operationService.findAll();
    }

    @JsonView(OperationView.All.class)
    @PostMapping
    public Operation save(@RequestBody Operation operation, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            operation = operationService.save(operation);
            return operation;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Operation> operations, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            operationService.save(operations);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Operation findOne(@PathVariable("id") int id) {
        return operationService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        operationService.delete(id);

    }

    @PutMapping("/{id}")
    public Operation updateCustomer(@PathVariable int id, @RequestBody Operation operation, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        operation.setId(id);
        operation = operationService.save(operation);
        return operation;
    }
}
