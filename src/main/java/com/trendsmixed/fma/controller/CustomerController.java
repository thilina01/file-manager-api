package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.Country;
import com.trendsmixed.fma.entity.Currency;
import com.trendsmixed.fma.entity.Customer;
import com.trendsmixed.fma.entity.CustomerItem;
import com.trendsmixed.fma.entity.Incoterm;
import com.trendsmixed.fma.entity.SaleType;
import com.trendsmixed.fma.jsonView.CustomerView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.CountryService;
import com.trendsmixed.fma.service.CurrencyService;
import com.trendsmixed.fma.service.CustomerService;
import com.trendsmixed.fma.service.IncotermService;
import com.trendsmixed.fma.service.SaleTypeService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private IncotermService incotermService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private SaleTypeService saleTypeService;
    @Autowired
    private CountryService countryService;

    @JsonView(CustomerView.AllAndIncotermAllAndSaleTypeAllAndCountryAllAndCurrencyAllAndCustomerItemListAndItemAll.class)
    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @JsonView(CustomerView.AllAndIncotermAllAndSaleTypeAllAndCountryAllAndCurrencyAllAndCustomerItemListAndItemAll.class)
    @PostMapping
    public Customer save(@RequestBody Customer customer, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        List<CustomerItem> customerItems = customer.getCustomerItemList();
        if (customerItems != null) {
            for (CustomerItem customerItem : customerItems) {
                customerItem.setCustomer(customer);
            }
        }
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

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Customer> customers, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            for (Customer customer : customers) {
                customer.setCode(customer.getCode().trim());

                Customer existingCustomer = customerService.findByCode(customer.getCode());
                if (existingCustomer != null) {
                    //itemsToRemove.add(item);
                    customer.setId(existingCustomer.getId());
                }

                Incoterm incoterm = customer.getIncoterm();
                if (incoterm != null) {
                    Incoterm existingIncoterm = incotermService.findByCode(incoterm.getCode());
                    if (existingIncoterm != null) {
                        incoterm.setId(existingIncoterm.getId());
                    } else {
                        customer.setIncoterm(null);
                    }
                }

                Currency currency = customer.getCurrency();
                if (currency != null) {
                    Currency existingCurrency = currencyService.findByCode(currency.getCode());
                    if (existingCurrency != null) {
                        currency.setId(existingCurrency.getId());
                    } else {
                        customer.setCurrency(null);
                    }
                }

                SaleType saleType = customer.getSaleType();
                if (saleType != null) {
                    SaleType existingSaleType = saleTypeService.findByCode(saleType.getCode());
                    if (existingSaleType != null) {
                        saleType.setId(existingSaleType.getId());
                    } else {
                        customer.setSaleType(null);
                    }
                }

                Country country = customer.getCountry();
                if (country != null) {
                    Country existingCountry = countryService.findByCode(country.getCode());
                    if (existingCountry != null) {
                        country.setId(existingCountry.getId());
                    } else {
                        customer.setCountry(null);
                    }
                }

            }
            customerService.save(customers);
        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Customer findOne(@PathVariable("id") int id) {
        return customerService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        customerService.delete(id);

    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        customer.setId(id);
        customer = customerService.save(customer);
        return customer;
    }
}
