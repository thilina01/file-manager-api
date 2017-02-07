package com.trendsmixed.fma.module.manpower;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.Manpower;
import com.trendsmixed.fma.module.manpower.ManpowerView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/manpowers")
public class ManpowerController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ManpowerService manpowerService;

    @JsonView(ManpowerView.All.class)
    @GetMapping
    public List<Manpower> findAll() {
        return manpowerService.findAll();
    }

    @JsonView(ManpowerView.All.class)
    @PostMapping
    public Manpower save(@RequestBody Manpower manpower, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            manpower = manpowerService.save(manpower);
            return manpower;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Manpower> manpowers, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            manpowerService.save(manpowers);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Manpower findOne(@PathVariable("id") int id) {
        return manpowerService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        manpowerService.delete(id);

    }

    @PutMapping("/{id}")
    public Manpower updateCustomer(@PathVariable int id, @RequestBody Manpower manpower, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        manpower.setId(id);
        manpower = manpowerService.save(manpower);
        return manpower;
    }
}
