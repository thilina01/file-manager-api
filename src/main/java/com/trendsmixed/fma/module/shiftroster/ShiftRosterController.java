package com.trendsmixed.fma.module.shiftroster;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/shiftRosters")
public class ShiftRosterController {

    private final AppSessionService appSessionService;
    private final ShiftRosterService service;

    @JsonView(ShiftRosterView.All.class)
    @GetMapping
    public Iterable<ShiftRoster> findAll() {
        return service.findAll();
    }

    @JsonView(ShiftRosterView.All.class)
    @GetMapping("/page")
    Page<ShiftRoster> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public ShiftRoster save(@RequestBody ShiftRoster shiftRoster,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            shiftRoster = service.save(shiftRoster);
            return shiftRoster;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ShiftRoster> shiftRosters,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            service.save(shiftRosters);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ShiftRosterView.All.class)
    @GetMapping("/{id}")
    public ShiftRoster findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public ShiftRoster updateCustomer(@PathVariable int id, @RequestBody ShiftRoster shiftRoster,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        shiftRoster.setId(id);
        shiftRoster = service.save(shiftRoster);
        return shiftRoster;
    }
}
