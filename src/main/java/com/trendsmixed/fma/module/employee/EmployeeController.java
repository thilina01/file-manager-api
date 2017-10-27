package com.trendsmixed.fma.module.employee;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private EmployeeService service;

    @JsonView(EmployeeView.AllAndDesignationAllAndEmployeeCategoryAllAndShiftAllAndSectionAllAndLabourSourceAll.class)
    @GetMapping
    public Iterable<Employee> findAll() {
        return service.findAll();
    }

    @JsonView(EmployeeView.AllAndDesignationAllAndEmployeeCategoryAllAndShiftAllAndSectionAllAndLabourSourceAll.class)
    @GetMapping("/page")
    Page<Employee> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(EmployeeView.AllAndDesignationAllAndEmployeeCategoryAllAndShiftAllAndSectionAllAndLabourSourceAll.class)
    @PostMapping
    public Employee save(@RequestBody Employee employee, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            employee = service.save(employee);
            return employee;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Employee> employees, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            for (Employee employee : employees) {
                employee.setCode(employee.getCode().trim());
                employee.setCallingName(employee.getCallingName().trim());
                employee.setFullName(employee.getFullName().trim());
                Employee existingSection = service.findByCode(employee.getCode());
                if (existingSection != null) {
                    employee.setId(existingSection.getId());
                }
            }
            service.save(employees);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(EmployeeView.AllAndDesignationAllAndEmployeeCategoryAllAndShiftAllAndSectionAllAndLabourSourceAll.class)
    @GetMapping("/{id}")
    public Employee findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(EmployeeView.AllAndDesignationAllAndEmployeeCategoryAllAndShiftAllAndSectionAllAndLabourSourceAll.class)
    @PutMapping("/{id}")
    public Employee updateCustomer(@PathVariable int id, @RequestBody Employee employee, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        employee.setId(id);
        employee = service.save(employee);
        return employee;
    }

}
