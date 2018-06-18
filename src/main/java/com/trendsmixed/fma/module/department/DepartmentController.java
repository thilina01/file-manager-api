package com.trendsmixed.fma.module.department;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/departments")
public class DepartmentController {

    
    private final DepartmentService service;

    @JsonView(DepartmentView.All.class)
    @GetMapping
    public Iterable<Department> findAll() {
        return service.findAll();
    }

    @JsonView(DepartmentView.All.class)
    @GetMapping("/page")
    Page<Department> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(DepartmentView.All.class)
    @PostMapping
    public Department save(@RequestBody Department department) {

        
        try {
            department = service.save(department);
            return department;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Department> countries) {

        
        try {
            for (Department department : countries) {
                department.setCode(department.getCode().trim());
                department.setName(department.getName().trim());
                Department existingSection = service.findByCode(department.getCode());
                if (existingSection != null) {
                    department.setId(existingSection.getId());
                }
            }
            service.save(countries);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(DepartmentView.All.class)
    @GetMapping("/{id}")
    public Department findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @JsonView(DepartmentView.All.class)
    @PutMapping("/{id}")
    public Department updateCustomer(@PathVariable int id, @RequestBody Department department) {
        
        department.setId(id);
        department = service.save(department);
        return department;
    }

}
