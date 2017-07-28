package com.trendsmixed.fma.module.customer;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.country.Country;
import com.trendsmixed.fma.module.currency.Currency;
import com.trendsmixed.fma.module.customeritem.CustomerItem;
import com.trendsmixed.fma.module.incoterm.Incoterm;
import com.trendsmixed.fma.module.customertype.CustomerType;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.country.CountryService;
import com.trendsmixed.fma.module.currency.CurrencyService;
import com.trendsmixed.fma.module.incoterm.IncotermService;
import com.trendsmixed.fma.module.customertype.CustomerTypeService;
import com.trendsmixed.fma.utility.Page;
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

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private CustomerService service;
    @Autowired
    private IncotermService incotermService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private CustomerTypeService customerTypeService;
    @Autowired
    private CountryService countryService;

    @JsonView(CustomerView.AllAndIncotermAllAndCustomerTypeAllAndCountryAllAndCurrencyAllAndCustomerItemListAndItemAll.class)
    @GetMapping
    public Iterable<Customer> findAll() {
        return service.findAll();
    }

    @JsonView(CustomerView.All.class)
    @GetMapping("/page")
    Page<Customer> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    //@JsonView(CustomerView.AllAndIncotermAllAndCustomerTypeAllAndCountryAllAndCurrencyAllAndCustomerItemListAndItemAll.class)
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
            customer = service.save(customer);
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

                Customer existingCustomer = service.findByCode(customer.getCode());
                if (existingCustomer != null) {
                    //itemsToRemove.add(item);
                    customer.setId(existingCustomer.getId());
                }

                Incoterm incoterm = customer.getIncoterm();
                if (incoterm != null) {
                    String incotermCode = incoterm.getCode();
                    String incotermName = incoterm.getName();
                    if (incotermCode != null) {
                        incoterm = incotermService.findByCode(incotermCode);
                    } else if (incotermName != null) {
                        incoterm = incotermService.findByName(incotermName);
                    }
                }
                if (incoterm == null || incoterm.getId() == null) {
                    incoterm = incotermService.findByCode("NA");
                }
                customer.setIncoterm(incoterm);

                Currency currency = customer.getCurrency();
                if (currency != null) {
                    String currencyCode = currency.getCode() != null ? currency.getCode().trim() : "NA";
                    currency = currencyService.findByCode(currencyCode);
                }
                
                if (currency == null) {
                    currency = currencyService.findByCode("NA");
                }
                customer.setCurrency(currency);

                CustomerType customerType = customer.getCustomerType();
                if (customerType != null) {
                    String customerTypeCode = customerType.getCode();
                    String customerTypeName = customerType.getName();
                    if (customerTypeCode != null) {
                        customerType = customerTypeService.findByCode(customerTypeCode);
                    } else if (customerTypeName != null) {
                        customerType = customerTypeService.findByName(customerTypeName);
                    }
                }
                if (customerType == null || customerType.getId() == null) {
                    customerType = customerTypeService.findByCode("NA");
                }
                customer.setCustomerType(customerType);

                Country country = customer.getCountry();
                if (country != null) {
                    String countryCode = country.getCode();
                    String countryName = country.getName();
                    if (countryCode != null) {
                        country = countryService.findByCode(countryCode);
                    } else if (countryName != null) {
                        country = countryService.findByName(countryName);
                    }
                }
                if (country == null || country.getId() == null) {
                    country = countryService.findByCode("NA");
                }
                customer.setCountry(country);

            }
            service.save(customers);
        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(CustomerView.AllAndIncotermAllAndCustomerTypeAllAndCountryAllAndCurrencyAll.class)
    @GetMapping("/{id}")
    public Customer findOne(@PathVariable("id") int id
    ) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request
    ) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable int id,
            @RequestBody Customer customer,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request
    ) {
        appSessionService.isValid(email, request);
        customer.setId(id);
        customer = service.save(customer);
        return customer;
    }
}
