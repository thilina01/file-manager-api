package com.trendsmixed.fma.module.employeecategory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;

@RestController
@CrossOrigin
@RequestMapping("/employeeCategories")
public class EmployeeCategoryController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private EmployeeCategoryService service;

    @JsonView(EmployeeCategoryView.All.class)
    @GetMapping
    public Iterable<EmployeeCategory> findAll() {
        return service.findAll();
    }

    @JsonView(EmployeeCategoryView.All.class)
    @GetMapping("/page")
    Page<EmployeeCategory> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public EmployeeCategory save(@RequestBody EmployeeCategory employeeCategory,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            employeeCategory = service.save(employeeCategory);
            return employeeCategory;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<EmployeeCategory> employeeCategories,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            service.save(employeeCategories);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(EmployeeCategoryView.All.class)
    @GetMapping("/{id}")
    public EmployeeCategory findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public EmployeeCategory updateCustomer(@PathVariable int id, @RequestBody EmployeeCategory employeeCategory,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        employeeCategory.setId(id);
        employeeCategory = service.save(employeeCategory);
        return employeeCategory;
    }
}
