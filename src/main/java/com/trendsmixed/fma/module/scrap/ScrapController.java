package com.trendsmixed.fma.module.scrap;

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

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;

@RestController
@CrossOrigin
@RequestMapping("/scraps")
public class ScrapController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ScrapService service;

    @JsonView(ScrapView.All.class)
    @GetMapping
    public Iterable<Scrap> findAll() {
        return service.findAll();
    }

    @JsonView(ScrapView.AllAndItemTypeAllAndLossReasonAllAndOperationTypeAllAndSectionAllAndJobAll.class)
    @GetMapping("/page")
    Page<Scrap> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @JsonView(ScrapView.All.class)
    @PostMapping
    public Scrap save(@RequestBody Scrap scrap, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            scrap = service.save(scrap);
            return scrap;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Scrap> scraps,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(scraps);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ScrapView.AllAndItemTypeAllAndLossReasonAllAndOperationTypeAllAndSectionAllAndJobAll.class)
    @GetMapping("/{id}")
    public Scrap findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(ScrapView.All.class)
    @PutMapping("/{id}")
    public Scrap updateCustomer(@PathVariable int id, @RequestBody Scrap scrap,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        scrap.setId(id);
        scrap = service.save(scrap);
        return scrap;
    }
}