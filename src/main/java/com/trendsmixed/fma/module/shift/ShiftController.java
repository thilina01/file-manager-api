package com.trendsmixed.fma.module.shift;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/shifts")
public class ShiftController {

    @Autowired
    private ShiftService service;
    @Autowired
    private AppSessionService appSessionService;

    @JsonView(ShiftView.All.class)
    @PostMapping
    public Shift save(@RequestBody Shift shift, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            shift = service.save(shift);

            return shift;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping
    @JsonView(ShiftView.All.class)
    public Iterable<Shift> findAll() {
        return service.findAll();
    }

    @JsonView(ShiftView.All.class)
    @GetMapping("/{id}")
    public Shift findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @JsonView(ShiftView.All.class)
    @GetMapping("/page")
    Page<Shift> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @PutMapping("/{id}")
    public Shift updateCustomer(@PathVariable int id, @RequestBody Shift shift, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        shift.setId(id);
        shift = service.save(shift);
        return shift;
    }
}
