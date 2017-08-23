package com.trendsmixed.fma.module.salesorderitem;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/salesOrderItems")
public class SalesOrderItemController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private SalesOrderItemService salesOrderItemService;

    @GetMapping
    @JsonView(SalesOrderItemView.AllAndCustomerItemAllAndSalesOrderAllAndJobAll.class)
    public List<SalesOrderItem> findAll() {
        return salesOrderItemService.findAll();
    }

    @PostMapping
    public SalesOrderItem save(@RequestBody SalesOrderItem salesOrderItem, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            salesOrderItem = salesOrderItemService.save(salesOrderItem);
            return salesOrderItem;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SalesOrderItemView.AllAndCustomerItemAllAndItemAllAndSalesOrderAllAndJobAll.class)
    @GetMapping("/{id}")
    public SalesOrderItem findOne(@PathVariable("id") int id) {
        return salesOrderItemService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        salesOrderItemService.delete(id);

    }

    @PutMapping("/{id}")
    public SalesOrderItem updateCustomer(@PathVariable int id, @RequestBody SalesOrderItem salesOrderItem, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        salesOrderItem.setId(id);
        salesOrderItem = salesOrderItemService.save(salesOrderItem);
        return salesOrderItem;
    }
}
