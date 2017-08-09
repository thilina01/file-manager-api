package com.trendsmixed.fma.module.scrapcostperkg;

import com.fasterxml.jackson.annotation.JsonView;
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
@RequestMapping("/scrapCostPerKgs")
public class ScrapCostPerKgController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ScrapCostPerKgService service;

    @JsonView(ScrapCostPerKgView.All.class)
    @GetMapping
    public Iterable<ScrapCostPerKg> findAll() {
        return service.findAll();
    }

    @JsonView(ScrapCostPerKgView.All.class)
    @GetMapping("/page")
    Page<ScrapCostPerKg> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public ScrapCostPerKg save(@RequestBody ScrapCostPerKg scrapCostPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            scrapCostPerKg = service.save(scrapCostPerKg);
            return scrapCostPerKg;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ScrapCostPerKg> scrapCostPerKgs, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(scrapCostPerKgs);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(ScrapCostPerKgView.All.class)
    public ScrapCostPerKg findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public ScrapCostPerKg updateCustomer(@PathVariable int id, @RequestBody ScrapCostPerKg scrapCostPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        scrapCostPerKg.setId(id);
        scrapCostPerKg = service.save(scrapCostPerKg);
        return scrapCostPerKg;
    }

}
