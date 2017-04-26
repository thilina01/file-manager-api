package com.trendsmixed.fma.module.manpowertype;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.ManpowerType;
import com.trendsmixed.fma.module.manpowertype.ManpowerTypeView;
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
@RequestMapping("/manpowerTypes")
public class ManpowerTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ManpowerTypeService manpowerTypeService;

    @JsonView(ManpowerTypeView.All.class)
    @GetMapping
    public List<ManpowerType> findAll() {
        return manpowerTypeService.findAll();
    }

    @JsonView(ManpowerTypeView.All.class)
    @PostMapping
    public ManpowerType save(@RequestBody ManpowerType manpowerType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            manpowerType = manpowerTypeService.save(manpowerType);
            return manpowerType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ManpowerType findOne(@PathVariable("id") int id) {
        return manpowerTypeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        manpowerTypeService.delete(id);
    }

    @PutMapping("/{id}")
    public ManpowerType updateCustomer(@PathVariable int id, @RequestBody ManpowerType manpowerType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        manpowerType.setId(id);
        manpowerType = manpowerTypeService.save(manpowerType);
        return manpowerType;
    }
}