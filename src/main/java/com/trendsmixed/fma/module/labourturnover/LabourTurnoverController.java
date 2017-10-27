package com.trendsmixed.fma.module.labourturnover;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/labourTurnovers")
public class LabourTurnoverController {

    private final AppSessionService appSessionService;
    private final LabourTurnoverService service;

    @JsonView(LabourTurnoverView.AllAndLabourSource.class)
    @GetMapping
    public Iterable<LabourTurnover> findAll() {
        return service.findAll();
    }

    @JsonView(LabourTurnoverView.AllAndLabourSource.class)
    @GetMapping("/page")
    Page<LabourTurnover> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    @JsonView(LabourTurnoverView.AllAndLabourSource.class)
    public LabourTurnover save(@RequestBody LabourTurnover labourTurnover, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            labourTurnover = service.save(labourTurnover);
            return labourTurnover;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<LabourTurnover> labourTurnovers, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(labourTurnovers);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(LabourTurnoverView.AllAndLabourSource.class)
    public LabourTurnover findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    @JsonView(LabourTurnoverView.AllAndLabourSource.class)
    public LabourTurnover updateCustomer(@PathVariable int id, @RequestBody LabourTurnover labourTurnover, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        labourTurnover.setId(id);
        labourTurnover = service.save(labourTurnover);
        return labourTurnover;
    }

}
