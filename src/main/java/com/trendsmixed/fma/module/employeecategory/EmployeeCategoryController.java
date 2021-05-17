package com.trendsmixed.fma.module.employeecategory;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/employeeCategories")
public class EmployeeCategoryController {

    
    private final EmployeeCategoryService service;

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
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
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
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
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
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public EmployeeCategory updateCustomer(@PathVariable int id, @RequestBody EmployeeCategory employeeCategory,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        employeeCategory.setId(id);
        employeeCategory = service.save(employeeCategory);
        return employeeCategory;
    }
}
