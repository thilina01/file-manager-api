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
import java.text.ParseException;
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

    @JsonView(CustomerItemView.AllAndCustomerAllAndItemAll.class)
    @PostMapping("/pageByCustomer")
    Page<CustomerItem> pageByCustomer(Pageable pageable, @RequestBody Customer customer) {
        if (customer.getId() == null) {
            customer = customerService.findByCode(customer.getCode());
        }
        return new Page<>(service.findByCustomer(customer, pageable));
    }

    @PostMapping("/comboByCustomer")
    List<Combo> comboByCustomer(@RequestBody Customer customer) {
        if (customer.getId() == null) {
            customer = customerService.findByCode(customer.getCode());
        }
        return service.getComboByCustomer(customer);
    }

    @GetMapping(value = "/itemAndCustomerPage", params = { "item", "customer" })
    public Page<CustomerItem> itemAndCustomerPage(@RequestParam("item") String item,
            @RequestParam("customer") String customer, Pageable pageable) throws ParseException {
        return new Page(service.findByItemAndCustomer(new Item(Integer.valueOf(item)),
                new Customer(Integer.valueOf(customer)), pageable));
    }

    @GetMapping(value = "/itemPage", params = { "item" })
    public Page<CustomerItem> itemPage(@RequestParam("item") String item, Pageable pageable) throws ParseException {
        return new Page(service.findByItem(new Item(Integer.valueOf(item)), pageable));
    }

    @GetMapping(value = "/customerPage", params = { "customer" })
    public Page<CustomerItem> customerPage(@RequestParam("customer") String customer, Pageable pageable)
            throws ParseException {
        return new Page(service.findByCustomer(new Customer(Integer.valueOf(customer)), pageable));
    }

    @JsonView(CustomerItemView.AllAndCustomerAllAndItemAll.class)
     @GetMapping(value = "/customerItem")
    public Page<CustomerItem> getCustomerItem(
        @RequestParam(value = "customer", required = false, defaultValue = "0") String customer, 
        @RequestParam(value = "item", required = false, defaultValue = "0") String item,
        @RequestParam(value = "code", required = false, defaultValue = "0") String code,
        Pageable pageable) throws ParseException {
        Page<CustomerItem> page ;
        if(!code.equals("0")){
            page = new Page(service.findByCode(code, pageable));
        }
       else if(item.equals("0")){
            page = new Page(service.findByCustomer(new Customer(Integer.valueOf(customer)),  pageable));
        }
        else if(customer.equals("0")){
            page = new Page(service.findByItem(new Item(Integer.valueOf(item)), pageable));
        }
        
        else{
            page = new Page(service.findByItemAndCustomer(new Item(Integer.valueOf(item)), new Customer(Integer.valueOf(customer)), pageable));
    }
        
        return page;
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(CustomerItemView.AllAndCustomerAllAndItemAll.class)
    @GetMapping("/customer/{id}")
    public Iterable<CustomerItem> findByCustomer(@PathVariable("id") int id) {
        return service.findByCustomer(new Customer(id));
    }

    @PostMapping
    public CustomerItem save(@RequestBody CustomerItem customerItems,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
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
    public void saveMany(@RequestBody List<CustomerItem> customerItems,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
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
    @PostMapping("/pageByItem")
    Page<CustomerItem> pageByItem(Pageable pageable, @RequestBody Item item) {
        if (item.getId() == null) {
            item = itemService.findByCode(item.getCode());
        }
        return new Page<>(service.findByItem(item, pageable));
    }

    @JsonView(CustomerItemView.AllAndCustomerAllAndItemAll.class)
    @GetMapping("/byCustomerIdAndItemId/{customerId}/{itemId}")
    public CustomerItem byCustomerIdAndItemId(@PathVariable("customerId") int customerId,
            @PathVariable("itemId") int itemId) {
        Customer customer = customerService.findOne(customerId);
        Item item = itemService.findOne(itemId);
        return service.findByCustomerAndItem(customer, item);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public CustomerItem updateCustomer(@PathVariable int id, @RequestBody CustomerItem customerItems,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        customerItems.setId(id);
        customerItems = service.save(customerItems);
        return customerItems;
    }

}
