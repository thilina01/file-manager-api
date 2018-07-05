package com.trendsmixed.fma.module.resourceutilization;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.employee.Employee;
import com.trendsmixed.fma.module.machine.Machine;
import com.trendsmixed.fma.module.shift.Shift;
import com.trendsmixed.fma.utility.Format;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/resourceUtilizations")
public class ResourceUtilizationController {

    
    private final ResourceUtilizationService service;

    @GetMapping
    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAllAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    public Iterable<ResourceUtilization> findAll() {
        return service.findAll();
    }

    @JsonView(ResourceUtilizationView.AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAllAndAllAndControlPointAllWorkCenterCostCenterSection.class)
    @GetMapping(value = "/machineAndEmployeeAndShiftAndProductionDateBetween")
    public Page<ResourceUtilization> getMachineAndEmployeeAndShiftAndProductionDateBetweenPage(
        @RequestParam(value = "machine", required = false, defaultValue = "0") String machine,
        @RequestParam(value = "employee", required = false, defaultValue = "0") String employee,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        @RequestParam(value = "shift", required = false, defaultValue = "0") String shift,
        Pageable pageable) throws ParseException {
        Page<ResourceUtilization> page ;

        if(machine.equals("0") && employee.equals("0") && shift.equals("0") ){
            page = new Page(service.findByProductionProductionDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else if(machine.equals("0") && employee.equals("0")){
            page = new Page(service.findByProductionProductionDateBetweenAndProductionShift(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Shift(Integer.valueOf(shift)), pageable));
        }
        else if(employee.equals("0") && shift.equals("0")){
            page = new Page(service.findByMachineAndProductionProductionDateBetween(new Machine(Integer.valueOf(machine)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else if(shift.equals("0") && machine.equals("0")){
            page = new Page(service.findByProductionProductionDateBetweenAndEmployee(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Employee(Integer.valueOf(employee)), pageable));
        }
        else if(machine.equals("0")){
            page = new Page(service.findByEmployeeAndProductionProductionDateBetweenAndProductionShift(new Employee(Integer.valueOf(employee)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Shift(Integer.valueOf(shift)), pageable));
        }
        else if(employee.equals("0")){
            page = new Page(service.findByMachineAndProductionProductionDateBetweenAndProductionShift(new Machine(Integer.valueOf(machine)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Shift(Integer.valueOf(shift)), pageable));
        }
        else if(shift.equals("0")){
            page = new Page(service.findByMachineAndProductionProductionDateBetweenAndEmployee(new Machine(Integer.valueOf(machine)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Employee(Integer.valueOf(employee)), pageable));
        }
        else{
            page = new Page(service.findByMachineAndEmployeeAndProductionProductionDateBetweenAndProductionShift(new Machine(Integer.valueOf(machine)),new Employee(Integer.valueOf(employee)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Shift(Integer.valueOf(shift)), pageable));
        }
        return page;
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
    public ResourceUtilization save(@RequestBody ResourceUtilization resourceUtilization) {
        
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
    public void saveMany(@RequestBody List<ResourceUtilization> resourceUtilizations) {

        
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

