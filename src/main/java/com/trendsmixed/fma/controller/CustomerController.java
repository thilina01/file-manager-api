package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.Customer;
import com.trendsmixed.fma.jsonView.CustomerView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.CustomerService;
import java.util.List;
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
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private CustomerService customerService;

    @JsonView(CustomerView.AllAndIncotermAllAndCustTypeAllAndCountryAllAndCurrencyAll.class)
    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @JsonView(CustomerView.AllAndIncotermAllAndCustTypeAllAndCountryAllAndCurrencyAll.class)
    @PostMapping
    public Customer save(@RequestBody Customer customer, @RequestHeader(value = "email", defaultValue = "") String email) {
        AppSession appSession = appSessionService.findOne(email);
        if (appSession == null) {
            throw new Error("Unauthorized access");
        } else {
            try {
                customer = customerService.save(customer);
                return customer;

            } catch (Throwable e) {
                while (e.getCause() != null) {
                    e = e.getCause();
                }
                throw new Error(e.getMessage());
            }
        }
    }

    @GetMapping("/{id}")
    public Customer findOne(@PathVariable("id") int id) {
        return customerService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable int id) {
        customerService.delete(id);
        return "Deleted";

    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customer.setId(id);
        customer = customerService.save(customer);
        return customer;
    }
}
