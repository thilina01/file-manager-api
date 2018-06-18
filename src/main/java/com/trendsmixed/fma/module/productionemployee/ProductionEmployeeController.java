package com.trendsmixed.fma.module.productionemployee;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.employee.Employee;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.shift.Shift;
import com.trendsmixed.fma.utility.Format;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/productionEmployees")
public class ProductionEmployeeController {

    
    private final ProductionEmployeeService service;

    @JsonView(ProductionEmployeeView.All.class)
    @GetMapping
    public Iterable<ProductionEmployee> findAll() {
        return service.findAll();
    }

    @JsonView(ProductionEmployeeView.AllAndProductionAllShiftAllAndControlPointAllWorkCenterCostCenterSectionAndEmployeeAll.class)
    @GetMapping(value = "/sectionAndProductionDurationPage", params = {"section", "startDate", "endDate"})
    public Page<ProductionEmployee> sectionAndProductionDurationPage(@RequestParam("section") String section, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateBetween(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @JsonView(ProductionEmployeeView.AllAndProductionAllShiftAllAndControlPointAllWorkCenterCostCenterSectionAndEmployeeAll.class)
    @GetMapping(value = "/productionDateAndShiftPage", params = {"productionDate", "shift"})
    public Page<ProductionEmployee> productionDateAndShiftPage(@RequestParam("productionDate") String productionDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionProductionDateAndProductionShift(Format.yyyy_MM_dd.parse(productionDate), new Shift(Integer.valueOf(shift)), pageable));
    }

    @JsonView(ProductionEmployeeView.AllAndProductionAllShiftAllAndControlPointAllWorkCenterCostCenterSectionAndEmployeeAll.class)
    @GetMapping(value = "/productionDurationAndShiftPage", params = {"startDate", "endDate", "shift"})
    public Page<ProductionEmployee> productionDurationAndShiftPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionProductionDateBetweenAndProductionShift(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Shift(Integer.valueOf(shift)), pageable));
    }

    @JsonView(ProductionEmployeeView.AllAndProductionAllShiftAllAndControlPointAllWorkCenterCostCenterSectionAndEmployeeAll.class)
    @GetMapping(value = "/productionDurationPage", params = {"startDate", "endDate"})
    public Page<ProductionEmployee> productionDurationPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionProductionDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @JsonView(ProductionEmployeeView.AllAndProductionAllShiftAllAndControlPointAllWorkCenterCostCenterSectionAndEmployeeAll.class)
    @GetMapping(value = "/productionDurationAndEmployeePage", params = {"startDate", "endDate", "employee"})
    public Page<ProductionEmployee> productionDurationAndEmployeePage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("employee") String employee, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionProductionDateBetweenAndEmployee(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Employee(Integer.valueOf(employee)), pageable));
    }

    @JsonView(ProductionEmployeeView.AllAndProductionAllShiftAllAndControlPointAllWorkCenterCostCenterSectionAndEmployeeAll.class)
    @GetMapping(value = "/productionDateAndEmployeePage", params = {"productionDate", "employee"})
    public Page<ProductionEmployee> productionDateAndEmployeePage(@RequestParam("productionDate") String productionDate, @RequestParam("employee") String employee, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionProductionDateAndEmployee(Format.yyyy_MM_dd.parse(productionDate), new Employee(Integer.valueOf(employee)), pageable));
    }

    @JsonView(ProductionEmployeeView.AllAndProductionAllShiftAllAndControlPointAllWorkCenterCostCenterSectionAndEmployeeAll.class)
    @GetMapping(value = "/sectionAndEmployeeAndProductionDurationAndShiftPage", params = {"section", "startDate", "endDate", "shift", "employee"})
    public Page<ProductionEmployee> sectionAndEmployeeAndProductionDurationAndShiftPage(@RequestParam("section") String section, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("employee") String employee, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionControlPointWorkCenterCostCenterSectionAndEmployeeAndProductionProductionDateBetweenAndProductionShift(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Employee(Integer.valueOf(employee)), new Shift(Integer.valueOf(shift)), pageable));
    }

    @JsonView(ProductionEmployeeView.AllAndProductionAllShiftAllAndControlPointAllWorkCenterCostCenterSectionAndEmployeeAll.class)
    @GetMapping(value = "/sectionAndEmployeeAndProductionDateAndShiftPage", params = {"section", "productionDate", "shift", "employee"})
    public Page<ProductionEmployee> sectionAndEmployeeAndProductionDateAndShiftPage(@RequestParam("section") String section, @RequestParam("productionDate") String productionDate, @RequestParam("shift") String shift, @RequestParam("employee") String employee, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionControlPointWorkCenterCostCenterSectionAndEmployeeAndProductionProductionDateAndProductionShift(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(productionDate), new Shift(Integer.valueOf(shift)), new Employee(Integer.valueOf(employee)), pageable));
    }

    @JsonView(ProductionEmployeeView.AllAndProductionAllShiftAllAndControlPointAllWorkCenterCostCenterSectionAndEmployeeAll.class)
    @GetMapping("/page")
    Page<ProductionEmployee> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @JsonView(ProductionEmployeeView.All.class)
    @PostMapping
    public ProductionEmployee save(@RequestBody ProductionEmployee productionEmployee,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {
            productionEmployee = service.save(productionEmployee);
            return productionEmployee;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ProductionEmployee> productionEmployees,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {

            service.save(productionEmployees);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ProductionEmployeeView.All.class)
    @GetMapping("/{id}")
    public ProductionEmployee findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.delete(id);
    }

    @JsonView(ProductionEmployeeView.All.class)
    @PutMapping("/{id}")
    public ProductionEmployee updateCustomer(@PathVariable int id, @RequestBody ProductionEmployee productionEmployee,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        productionEmployee.setId(id);
        productionEmployee = service.save(productionEmployee);
        return productionEmployee;
    }
}
