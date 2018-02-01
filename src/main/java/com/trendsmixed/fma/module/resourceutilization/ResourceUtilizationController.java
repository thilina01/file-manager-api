package com.trendsmixed.fma.module.resourceutilization;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.trendsmixed.fma.module.employee.Employee;
import com.trendsmixed.fma.module.shift.Shift;
import com.trendsmixed.fma.module.machine.Machine;
import lombok.AllArgsConstructor;
import com.trendsmixed.fma.utility.Format;
import java.text.ParseException;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/resourceUtilizations")
public class ResourceUtilizationController {

    private final AppSessionService appSessionService;
    private final ResourceUtilizationService service;

    @GetMapping
    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAllAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    public Iterable<ResourceUtilization> findAll() {
        return service.findAll();
    }
    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAllAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping(value = "/productionDateAndShiftPage", params = {"productionDate", "shift"})
    public Page<ResourceUtilization> productionDateAndShiftPage(@RequestParam("productionDate") String productionDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionProductionDateAndProductionShift(Format.yyyy_MM_dd.parse(productionDate), new Shift(Integer.valueOf(shift)), pageable));
    }
    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAllAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping(value = "/productionDurationAndShiftPage", params = {"startDate", "endDate", "shift"})
    public Page<ResourceUtilization> productionDurationAndShiftPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionProductionDateBetweenAndProductionShift(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Shift(Integer.valueOf(shift)), pageable));
    }
    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAllAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping(value = "/productionDurationPage", params = {"startDate", "endDate"})
    public Page<ResourceUtilization> productionDurationPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionProductionDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }
    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAllAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping(value = "/productionDurationAndEmployeePage", params = {"startDate", "endDate", "employee"})
    public Page<ResourceUtilization> productionDurationAndEmployeePage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("employee") String employee, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionProductionDateBetweenAndEmployee(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Employee(Integer.valueOf(employee)), pageable));
    }
    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAllAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping(value = "/productionDateAndEmployeePage", params = {"productionDate", "employee"})
    public Page<ResourceUtilization> productionDateAndEmployeePage(@RequestParam("productionDate") String productionDate, @RequestParam("employee") String employee, Pageable pageable) throws ParseException {
        return new Page(service.findByProductionProductionDateAndEmployee(Format.yyyy_MM_dd.parse(productionDate), new Employee(Integer.valueOf(employee)), pageable));
    }
    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAllAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping(value = "/machineAndProductionDurationPage", params = {"machine", "startDate", "endDate"})
    public Page<ResourceUtilization> machineAndProductionDurationPage(@RequestParam("machine") String machine, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByMachineAndProductionProductionDateBetween(new Machine(Integer.valueOf(machine)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }
    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAllAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping(value = "/machineAndEmployeeAndProductionDateAndShiftPage", params = {"machine", "productionDate", "shift", "employee"})
    public Page<ResourceUtilization> machineAndEmployeeAndProductionDateAndShiftPage(@RequestParam("machine") String machine, @RequestParam("productionDate") String productionDate, @RequestParam("shift") String shift, @RequestParam("employee") String employee, Pageable pageable) throws ParseException {
        return new Page(service.findByMachineAndEmployeeAndProductionProductionDateAndProductionShift(new Machine(Integer.valueOf(machine)), Format.yyyy_MM_dd.parse(productionDate),  new Employee(Integer.valueOf(employee)),new Shift(Integer.valueOf(shift)), pageable));
    }
    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAllAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping(value = "/machineAndEmployeeAndProductionDurationAndShiftPage", params = {"machine", "startDate", "endDate", "shift", "employee"})
    public Page<ResourceUtilization> machineAndEmployeeAndProductionDurationAndShiftPage(@RequestParam("machine") String machine, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("employee") String employee, @RequestParam("shift") String shift, Pageable pageable) throws ParseException {
        return new Page(service.findByMachineAndEmployeeAndProductionProductionDateBetweenAndProductionShift(new Machine(Integer.valueOf(machine)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Employee(Integer.valueOf(employee)), new Shift(Integer.valueOf(shift)), pageable));
    }

    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAllAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping("/page")
    Page<ResourceUtilization> page(Pageable pageable) {
        return new Page<ResourceUtilization>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAllAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    public ResourceUtilization save(@RequestBody ResourceUtilization resourceUtilization, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            resourceUtilization = service.save(resourceUtilization);
            return resourceUtilization;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ResourceUtilization> resourceUtilizations, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(resourceUtilizations);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAllAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping("/{id}")
    public ResourceUtilization findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);

    }

    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAllAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @PutMapping("/{id}")
    public ResourceUtilization updateCustomer(@PathVariable int id, @RequestBody ResourceUtilization resourceUtilization) {
        resourceUtilization.setId(id);
        resourceUtilization = service.save(resourceUtilization);
        return resourceUtilization;
    }

}

