package com.trendsmixed.fma.module.shift;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.Shift;
import com.trendsmixed.fma.module.shift.ShiftView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ShiftService shiftService;
    @Autowired
    private AppSessionService appSessionService;

    @JsonView(ShiftView.All.class)
    @PostMapping
    public Shift save(@RequestBody Shift shift, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            shift = shiftService.save(shift);

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
    public List<Shift> findAll() {
        return shiftService.findAll();
    }

    @GetMapping("/{id}")
    public Shift findOne(@PathVariable("id") int id) {
        return shiftService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        shiftService.delete(id);

    }

    @PutMapping("/{id}")
    public Shift updateCustomer(@PathVariable int id, @RequestBody Shift shift, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        shift.setId(id);
        shift = shiftService.save(shift);
        return shift;
    }
}
