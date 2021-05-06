package com.trendsmixed.fma.module.customer;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.address.Address;
import com.trendsmixed.fma.module.contact.Contact;
import com.trendsmixed.fma.module.currency.Currency;
import com.trendsmixed.fma.module.currency.CurrencyService;
import com.trendsmixed.fma.module.customeritem.CustomerItem;
import com.trendsmixed.fma.module.customertype.CustomerType;
import com.trendsmixed.fma.module.customertype.CustomerTypeService;
import com.trendsmixed.fma.module.incoterm.Incoterm;
import com.trendsmixed.fma.module.incoterm.IncotermService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;
    private final IncotermService incotermService;
    private final CurrencyService currencyService;
    private final CustomerTypeService customerTypeService;

    @JsonView(CustomerView.AllAndIncotermAllAndCustomerTypeAllAndCurrencyAllAndCustomerItemListAndItemAll.class)
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

    @PostMapping
    public Customer save(@RequestBody Customer customer) {

        List<CustomerItem> customerItems = customer.getCustomerItemList();
        if (customerItems != null) {
            for (CustomerItem customerItem : customerItems) {
                customerItem.setCustomer(customer);
            }
        }
        try {

            List<Contact> contacts = customer.getContactList();
            List<Address> addresses = customer.getAddressList();

            if (contacts != null) {
                for (Contact contact : contacts) {
                    contact.setCustomer(customer);
                }
            }
            if (addresses != null) {
                for (Address address : addresses) {
                    address.setCustomer(customer);
                }
            }
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
    public void saveMany(@RequestBody List<Customer> customers) {

        try {
            for (Customer customer : customers) {

                customer.setCode(customer.getCode().trim());

                Customer existingCustomer = service.findByCode(customer.getCode());
                if (existingCustomer != null) {
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

    @JsonView(CustomerView.AllAndIncotermAllAndCustomerTypeAllAndCurrencyAllAndNotifyPartyAllAndContactAllAndContactTypeAllAndPaymentTermAllAndAddressAllAndAddressTypeAllAndCountryAllAndPortAllAndEmployeeAll.class)
    @GetMapping("/{id}")
    public Customer findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email) {

        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer,
            @RequestHeader(value = "email", defaultValue = "") String email) {

        customer.setId(id);
        customer = service.save(customer);
        return customer;
    }
}
