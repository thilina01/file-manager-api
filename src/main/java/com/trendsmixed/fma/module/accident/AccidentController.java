package com.trendsmixed.fma.module.accident;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import org.springframework.web.bind.annotation.*;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.treatment.Treatment;
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
