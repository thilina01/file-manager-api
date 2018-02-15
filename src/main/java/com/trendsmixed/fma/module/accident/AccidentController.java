package com.trendsmixed.fma.module.accident;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import org.springframework.web.bind.annotation.*;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.treatment.Treatment;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.employee.Employee;
import com.trendsmixed.fma.module.employee.EmployeeService;
import com.trendsmixed.fma.utility.Format;
import java.text.ParseException;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/accidents")
public class AccidentController {

    private final AppSessionService appSessionService;
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
    @GetMapping(value = "/accidentDurationPage", params = {"startDate", "endDate"})
    public Page<Accident> accidentDurationPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByAccidentDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @JsonView(AccidentView.AllAndAccidentTypeAllAndResponsiblePersonAndEmployeeAllAndMachineAllAndSectionAllAndShiftAllAndTreatmentAllAndTreatmentTypeAll.class)
    @GetMapping(value = "/accidentDateAndSectionPage", params = {"accidentDate", "section"})
    public Page<Accident> accidentDateAndSectionPage(@RequestParam("accidentDate") String accidentDate, @RequestParam("section") String section, Pageable pageable) throws ParseException {
        return new Page(service.findByAccidentDateAndSection(Format.yyyy_MM_dd.parse(accidentDate), new Section(Integer.valueOf(section)), pageable));
    }

    @JsonView(AccidentView.AllAndAccidentTypeAllAndResponsiblePersonAndEmployeeAllAndMachineAllAndSectionAllAndShiftAllAndTreatmentAllAndTreatmentTypeAll.class)
    @GetMapping(value = "/sectionAndAccidentDurationPage", params = {"section", "startDate", "endDate"})
    public Page<Accident> sectionAndAccidentDurationPage(@RequestParam("section") String section, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findBySectionAndAccidentDateBetween(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @JsonView(AccidentView.AllAndAccidentTypeAllAndResponsiblePersonAndEmployeeAllAndMachineAllAndSectionAllAndShiftAllAndTreatmentAllAndTreatmentTypeAll.class)
    @GetMapping(value = "/accidentDateAndEmployeePage", params = {"accidentDate", "employee"})
    public Page<Accident> accidentDateAndEmployeePage(@RequestParam("accidentDate") String accidentDate, @RequestParam("employee") String employee, Pageable pageable) throws ParseException {
        return new Page(service.findByAccidentDateAndEmployee(Format.yyyy_MM_dd.parse(accidentDate), new Employee(Integer.valueOf(employee)), pageable));
    }

    @JsonView(AccidentView.AllAndAccidentTypeAllAndResponsiblePersonAndEmployeeAllAndMachineAllAndSectionAllAndShiftAllAndTreatmentAllAndTreatmentTypeAll.class)
    @GetMapping(value = "/employeeAndAccidentDurationPage", params = {"employee", "startDate", "endDate"})
    public Page<Accident> employeeAndAccidentDurationPage(@RequestParam("employee") String employee, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByEmployeeAndAccidentDateBetween(new Employee(Integer.valueOf(employee)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }
    
    @JsonView(AccidentView.AllAndAccidentTypeAllAndResponsiblePersonAndEmployeeAllAndMachineAllAndSectionAllAndShiftAllAndTreatmentAllAndTreatmentTypeAll.class)
    @PostMapping("/pageByEmployee")
    Page<Accident> pageByEmployee(Pageable pageable, @RequestBody Employee employee) {
        if (employee.getId() == null) {
            employee = employeeService.findByCode(employee.getCode());
        }
        return new Page<>(service.findByEmployee(employee, pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(AccidentView.AllAndAccidentTypeAllAndResponsiblePersonAndEmployeeAllAndMachineAllAndSectionAllAndShiftAllAndTreatmentAllAndTreatmentTypeAll.class)
    @PostMapping
    public Accident save(@RequestBody Accident accident, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
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
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(AccidentView.AllAndAccidentTypeAllAndResponsiblePersonAndEmployeeAllAndMachineAllAndSectionAllAndShiftAllAndTreatmentAllAndTreatmentTypeAll.class)
    @PutMapping("/{id}")
    public Accident updateCustomer(@PathVariable int id, @RequestBody Accident accident, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        accident.setId(id);
        accident = service.save(accident);
        return accident;
    }
}
