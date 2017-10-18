package com.trendsmixed.fma.module.deliveryterm;

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
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;

@RestController
@CrossOrigin
@RequestMapping("/deliveryTerms")
public class DeliveryTermController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private DeliveryTermService service;

    @JsonView(DeliveryTermView.All.class)
    @GetMapping
    public Iterable<DeliveryTerm> findAll() {
        return service.findAll();
    }

    @JsonView(DeliveryTermView.All.class)
    @GetMapping("/page")
    Page<DeliveryTerm> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(DeliveryTermView.All.class)
    @PostMapping
    public DeliveryTerm save(@RequestBody DeliveryTerm deliveryTerm,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            deliveryTerm = service.save(deliveryTerm);
            return deliveryTerm;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<DeliveryTerm> deliveryTerms,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            service.save(deliveryTerms);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(DeliveryTermView.All.class)
    @GetMapping("/{id}")
    public DeliveryTerm findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @JsonView(DeliveryTermView.All.class)
    @PutMapping("/{id}")
    public DeliveryTerm updateCustomer(@PathVariable int id, @RequestBody DeliveryTerm deliveryTerm,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        deliveryTerm.setId(id);
        deliveryTerm = service.save(deliveryTerm);
        return deliveryTerm;
    }
}
