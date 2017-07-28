package com.trendsmixed.fma.module.manpowertype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
    private ManpowerTypeService service;

    @JsonView(ManpowerTypeView.All.class)
    @GetMapping
    public Iterable<ManpowerType> findAll() {
        return service.findAll();
    }

    @JsonView(ManpowerTypeView.All.class)
    @GetMapping("/page")
    Page<ManpowerType> page(Pageable pageable) {
        return new Page<ManpowerType>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(ManpowerTypeView.All.class)
    @PostMapping
    public ManpowerType save(@RequestBody ManpowerType manpowerType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            manpowerType = service.save(manpowerType);
            return manpowerType;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ManpowerTypeView.All.class)
    @GetMapping("/{id}")
    public ManpowerType findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @JsonView(ManpowerTypeView.All.class)
    @PutMapping("/{id}")
    public ManpowerType updateCustomer(@PathVariable int id, @RequestBody ManpowerType manpowerType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        manpowerType.setId(id);
        manpowerType = service.save(manpowerType);
        return manpowerType;
    }
}
