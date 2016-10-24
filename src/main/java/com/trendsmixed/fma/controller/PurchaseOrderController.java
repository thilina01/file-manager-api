package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.PurchaseOrder;
import com.trendsmixed.fma.jsonView.PurchaseOrderView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.PurchaseOrderService;
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
@RequestMapping("/purchaseOrders")
public class PurchaseOrderController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @JsonView(PurchaseOrderView.AllAndCustomerAllAndPurchaseOrderTypeAll.class)
    @GetMapping
    public List<PurchaseOrder> findAll() {
        return purchaseOrderService.findAll();
    }

    @JsonView(PurchaseOrderView.AllAndCustomerAllAndPurchaseOrderTypeAll.class)
    @PostMapping
    public PurchaseOrder save(@RequestBody PurchaseOrder purchaseOrder, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            purchaseOrder = purchaseOrderService.save(purchaseOrder);
            return purchaseOrder;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public PurchaseOrder findOne(@PathVariable("id") int id) {
        return purchaseOrderService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        purchaseOrderService.delete(id);

    }

    @PutMapping("/{id}")
    public PurchaseOrder updateCustomer(@PathVariable int id, @RequestBody PurchaseOrder purchaseOrder, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        purchaseOrder.setId(id);
        purchaseOrder = purchaseOrderService.save(purchaseOrder);
        return purchaseOrder;
    }
}
