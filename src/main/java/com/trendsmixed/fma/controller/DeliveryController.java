package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.Delivery;
import com.trendsmixed.fma.jsonView.DeliveryView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.DeliveryService;
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
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private DeliveryService deliveryService;

    @JsonView(DeliveryView.All.class)
    @GetMapping
    public List<Delivery> findAll() {
        return deliveryService.findAll();
    }

    @JsonView(DeliveryView.All.class)
    @PostMapping
    public Delivery save(@RequestBody Delivery delivery, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            delivery = deliveryService.save(delivery);
            return delivery;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Delivery findOne(@PathVariable("id") int id) {
        return deliveryService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        deliveryService.delete(id);

    }

    @PutMapping("/{id}")
    public Delivery updateCustomer(@PathVariable int id, @RequestBody Delivery delivery, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        delivery.setId(id);
        delivery = deliveryService.save(delivery);
        return delivery;
    }
}
