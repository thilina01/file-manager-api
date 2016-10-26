package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.SalesOrder;
import com.trendsmixed.fma.jsonView.SalesOrderView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.SalesOrderService;
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
@RequestMapping("/salesOrders")
public class SalesOrderController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private SalesOrderService salesOrderService;

    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping
    public List<SalesOrder> findAll() {
        return salesOrderService.findAll();
    }

    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @PostMapping
    public SalesOrder save(@RequestBody SalesOrder salesOrder, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            salesOrder = salesOrderService.save(salesOrder);
            return salesOrder;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public SalesOrder findOne(@PathVariable("id") int id) {
        return salesOrderService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        salesOrderService.delete(id);

    }

    @PutMapping("/{id}")
    public SalesOrder updateCustomer(@PathVariable int id, @RequestBody SalesOrder salesOrder, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        salesOrder.setId(id);
        salesOrder = salesOrderService.save(salesOrder);
        return salesOrder;
    }
}
