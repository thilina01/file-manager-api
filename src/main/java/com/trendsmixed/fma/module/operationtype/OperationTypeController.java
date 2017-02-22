package com.trendsmixed.fma.module.operationtype;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.OperationType;
import com.trendsmixed.fma.module.operationtype.OperationTypeView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
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
@RequestMapping("/operationTypes")
public class OperationTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private OperationTypeService operationTypeService;

    @JsonView(OperationTypeView.All.class)
    @GetMapping
    public List<OperationType> findAll() {
        return operationTypeService.findAll();
    }

    @JsonView(OperationTypeView.All.class)
    @PostMapping
    public OperationType save(@RequestBody OperationType operationType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            operationType = operationTypeService.save(operationType);
            return operationType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<OperationType> operationTypes, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            operationTypeService.save(operationTypes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public OperationType findOne(@PathVariable("id") int id) {
        return operationTypeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        operationTypeService.delete(id);

    }

    @PutMapping("/{id}")
    public OperationType updateCustomer(@PathVariable int id, @RequestBody OperationType operationType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        operationType.setId(id);
        operationType = operationTypeService.save(operationType);
        return operationType;
    }
}
