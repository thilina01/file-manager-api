package com.trendsmixed.fma.module.employee;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.log.LogExecution;
import com.trendsmixed.fma.module.designation.Designation;
import com.trendsmixed.fma.module.designation.DesignationService;
import com.trendsmixed.fma.module.employeecategory.EmployeeCategory;
import com.trendsmixed.fma.module.employeecategory.EmployeeCategoryService;
import com.trendsmixed.fma.module.labourtursource.LabourSource;
import com.trendsmixed.fma.module.labourtursource.LabourSourceService;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.section.SectionService;
import com.trendsmixed.fma.module.shift.Shift;
import com.trendsmixed.fma.module.shift.ShiftService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {
    
    private final EmployeeService service;
    private final DesignationService designationService;
    private final EmployeeCategoryService employeeCategoryService;
    private final LabourSourceService labourSourceService;
    private final SectionService sectionService;
    private final ShiftService shiftService;

    @LogExecution
    @JsonView(EmployeeView.AllAndDesignationAllAndEmployeeCategoryAllAndShiftAllAndSectionAllAndLabourSourceAll.class)
    @GetMapping
    public Iterable<Employee> findAll() {
        return service.findAll();
    }

    @LogExecution
    @JsonView(EmployeeView.AllAndDesignationAllAndEmployeeCategoryAllAndShiftAllAndSectionAllAndLabourSourceAll.class)
    @GetMapping("/page")
    Page<Employee> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @LogExecution
    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @LogExecution
    @GetMapping("/customer/{id}")
    public Employee findOneByCustomer(@PathVariable("id") int id) {
        return service.findOneByCustomerListId(id);
    }

    @LogExecution
    @JsonView(EmployeeView.AllAndDesignationAllAndEmployeeCategoryAllAndShiftAllAndSectionAllAndLabourSourceAll.class)
    @PostMapping
    public Employee save(@RequestBody Employee employee) {
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

    @LogExecution
    @PostMapping("/many")
    public void saveMany(@RequestBody List<Employee> employees) {
        Designation designation = designationService.findByCode("NA");
        EmployeeCategory employeeCategory = employeeCategoryService.findByCode("NA");
        LabourSource labourSource = labourSourceService.findByCode("NA");
        Section section = sectionService.findByCode("NA");
        Shift shift = shiftService.findByCode("NA");

        try {
            for (Employee employee : employees) {
                employee.setCode(employee.getCode().trim());
                employee.setCallingName(employee.getCallingName().trim());
                if (employee.getFullName() != null) {
                    employee.setFullName(employee.getFullName().trim());
                }
                if(employee.getDesignation()==null){
                    employee.setDesignation(designation);
                }
                if(employee.getEmployeeCategory()==null){
                    employee.setEmployeeCategory(employeeCategory);
                }
                if(employee.getLabourSource()==null){
                    employee.setLabourSource(labourSource);
                }
                if(employee.getLabourSource()==null){
                    employee.setLabourSource(labourSource);
                }
                if(employee.getShift()==null){
                    employee.setShift(shift);
                }
                if(employee.getSection()==null){
                    employee.setSection(section);
                }
                Employee existingEmployee = service.findByCode(employee.getCode());
                if (existingEmployee != null) {
                    employee.setId(existingEmployee.getId());
                }
            }
            service.save(employees);
        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @LogExecution
    @JsonView(EmployeeView.AllAndDesignationAllAndEmployeeCategoryAllAndShiftAllAndSectionAllAndLabourSourceAll.class)
    @GetMapping("/{id}")
    public Employee findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @LogExecution
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @LogExecution
    @JsonView(EmployeeView.AllAndDesignationAllAndEmployeeCategoryAllAndShiftAllAndSectionAllAndLabourSourceAll.class)
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employee.setId(id);
        employee = service.save(employee);
        return employee;
    }

}
