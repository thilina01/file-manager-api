package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.OrderType;
import com.trendsmixed.fma.jsonView.OrderTypeView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.OrderTypeService;
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
@RequestMapping("/orderTypes")
public class OrderTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private OrderTypeService orderTypeService;

    @JsonView(OrderTypeView.All.class)
    @GetMapping
    public List<OrderType> findAll() {
        return orderTypeService.findAll();
    }

    @PostMapping
    public OrderType save(@RequestBody OrderType orderType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            orderType = orderTypeService.save(orderType);
            return orderType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public OrderType findOne(@PathVariable("id") int id) {
        return orderTypeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        orderTypeService.delete(id);

    }

    @PutMapping("/{id}")
    public OrderType updateCustomer(@PathVariable int id, @RequestBody OrderType orderType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        orderType.setId(id);
        orderType = orderTypeService.save(orderType);
        return orderType;
    }
}
