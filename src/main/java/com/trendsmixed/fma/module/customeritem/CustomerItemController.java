package com.trendsmixed.fma.module.customeritem;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.customer.CustomerService;
import com.trendsmixed.fma.module.item.ItemService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/customerItems")
public class CustomerItemController {

    private final AppSessionService appSessionService;
    private final CustomerItemService service;
    private final CustomerService customerService;
    private final ItemService itemService;

    @JsonView(CustomerItemView.AllAndCustomerAllAndItemAll.class)
    @GetMapping
    public Iterable<CustomerItem> findAll() {
        return service.findAll();
    }

    @JsonView(CustomerItemView.AllAndCustomerAllAndItemAll.class)
    @GetMapping("/page")
    Page<CustomerItem> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public CustomerItem save(@RequestBody CustomerItem customerItems, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            customerItems = service.save(customerItems);
            return customerItems;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<CustomerItem> customerItems, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            for (CustomerItem customerItem : customerItems) {
                Customer customer = customerItem.getCustomer();
                if (customer != null) {
                    customerItem.setCustomer(customerService.findByCode(customer.getCode().trim()));
                }

                Item item = customerItem.getItem();
                if (item != null) {
                    customerItem.setItem(itemService.findByCode(item.getCode().trim()));
                }
            }
            service.save(customerItems);
        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(CustomerItemView.AllAndCustomerAllAndItemAll.class)
    @GetMapping("/{id}")
    public CustomerItem findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @JsonView(CustomerItemView.AllAndCustomerAllAndItemAll.class)
    @GetMapping("/byCustomerIdAndItemId/{customerId}/{itemId}")
    public CustomerItem byCustomerIdAndItemId(@PathVariable("customerId") int customerId, @PathVariable("itemId") int itemId) {
        Customer customer = customerService.findOne(customerId);
        Item item = itemService.findOne(itemId);
        return service.findByCustomerAndItem(customer, item);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public CustomerItem updateCustomer(@PathVariable int id, @RequestBody CustomerItem customerItems, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        customerItems.setId(id);
        customerItems = service.save(customerItems);
        return customerItems;
    }

}
