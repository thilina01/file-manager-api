package com.trendsmixed.fma.module.customertype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/customerTypes")
public class CustomerTypeController {

    private final AppSessionService appSessionService;
    private final CustomerTypeService service;

    @JsonView(CustomerTypeView.All.class)
    @GetMapping
    public Iterable<CustomerType> findAll() {
        return service.findAll();
    }

    @JsonView(CustomerTypeView.All.class)
    @GetMapping("/page")
    Page<CustomerType> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(CustomerTypeView.All.class)
    @PostMapping
    public CustomerType save(@RequestBody CustomerType customerType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            customerType = service.save(customerType);
            return customerType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(CustomerTypeView.All.class)
    @GetMapping("/{id}")
    public CustomerType findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public CustomerType updateCustomer(@PathVariable int id, @RequestBody CustomerType customerType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        customerType.setId(id);
        customerType = service.save(customerType);
        return customerType;
    }

}
