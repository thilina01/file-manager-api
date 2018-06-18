package com.trendsmixed.fma.module.accident;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.employee.Employee;
import com.trendsmixed.fma.module.employee.EmployeeService;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.treatment.Treatment;
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
@RequestMapping("/accidents")
public class AccidentController {

    
    private final AccidentService service;
    private final EmployeeService employeeService;

    @JsonView(AccidentView.AllAndAccidentTypeAllAndResponsiblePersonAndEmployeeAllAndMachineAllAndSectionAllAndShiftAllAndTreatmentAllAndTreatmentTypeAll.class)
    @GetMapping
    public Iterable<Accident> findAll() {
        return service.findAll();
    }

    @JsonView(AccidentView.AllAndAccidentTypeAllAndResponsiblePersonAndEmployeeAllAndMachineAllAndSectionAllAndShiftAllAndTreatmentAllAndTreatmentTypeAll.class)
    @GetMapping("/page")
    Page<Accident> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @JsonView(AccidentView.AllAndAccidentTypeAllAndResponsiblePersonAndEmployeeAllAndMachineAllAndSectionAllAndShiftAllAndTreatmentAllAndTreatmentTypeAll.class)
    @GetMapping(value = "/treatment")
    public Page<Accident> getTreatment(
        @RequestParam(value = "employee", required = false, defaultValue = "0") String employee,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<Accident> page ;
        if(employee.equals("0") ){
            page = new Page(service.findByAccidentDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } 
        else {
            page = new Page(service.findByEmployeeAndAccidentDateBetween(new Employee(Integer.valueOf(employee)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        return page;
    }

    @JsonView(AccidentView.AllAndAccidentTypeAllAndResponsiblePersonAndEmployeeAllAndMachineAllAndSectionAllAndShiftAllAndTreatmentAllAndTreatmentTypeAll.class)
    @GetMapping(value = "/accident")
    public Page<Accident> getAccident(
        @RequestParam(value = "section", required = false, defaultValue = "0") String section,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<Accident> page ;
        if(section.equals("0") ){
            page = new Page(service.findByAccidentDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } 
        else {
            page = new Page(service.findBySectionAndAccidentDateBetween(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        return page;
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(AccidentView.AllAndAccidentTypeAllAndResponsiblePersonAndEmployeeAllAndMachineAllAndSectionAllAndShiftAllAndTreatmentAllAndTreatmentTypeAll.class)
    @PostMapping
    public Accident save(@RequestBody Accident accident) {
        
        try {

            List<Treatment> treatmentes = accident.getTreatmentList();
            if (treatmentes != null) {
                for (Treatment treatment : treatmentes) {
                    treatment.setAccident(accident);
                }
            }
            accident = service.save(accident);
            return accident;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(AccidentView.AllAndAccidentTypeAllAndResponsiblePersonAndEmployeeAllAndMachineAllAndSectionAllAndShiftAllAndTreatmentAllAndTreatmentTypeAll.class)
    @GetMapping("/{id}")
    public Accident findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @JsonView(AccidentView.AllAndAccidentTypeAllAndResponsiblePersonAndEmployeeAllAndMachineAllAndSectionAllAndShiftAllAndTreatmentAllAndTreatmentTypeAll.class)
    @PutMapping("/{id}")
    public Accident updateCustomer(@PathVariable int id, @RequestBody Accident accident) {
        
        accident.setId(id);
        accident = service.save(accident);
        return accident;
    }
}
