package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.CustomerItem;
import com.trendsmixed.fma.jsonView.CustomerItemView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.CustomerItemService;
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
@RequestMapping("/customerItems")
public class CustomerItemController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private CustomerItemService customerItemsService;

    @JsonView(CustomerItemView.AllAndCustomerAllAndItemAll.class)
    @GetMapping
    public List<CustomerItem> findAll() {
        return customerItemsService.findAll();
    }

    @JsonView(CustomerItemView.AllAndCustomerAllAndItemAll.class)
    @PostMapping
    public CustomerItem save(@RequestBody CustomerItem customerItems, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            customerItems = customerItemsService.save(customerItems);
            return customerItems;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public CustomerItem findOne(@PathVariable("id") int id) {
        return customerItemsService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        customerItemsService.delete(id);

    }

    @PutMapping("/{id}")
    public CustomerItem updateCustomer(@PathVariable int id, @RequestBody CustomerItem customerItems, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        customerItems.setId(id);
        customerItems = customerItemsService.save(customerItems);
        return customerItems;
    }

}
