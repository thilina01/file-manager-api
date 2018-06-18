package com.trendsmixed.fma.module.deliveryterm;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/deliveryTerms")
public class DeliveryTermController {

    
    private final DeliveryTermService service;

    @JsonView(DeliveryTermView.All.class)
    @GetMapping
    public Iterable<DeliveryTerm> findAll() {
        return service.findAll();
    }

    @JsonView(DeliveryTermView.All.class)
    @GetMapping("/page")
    Page<DeliveryTerm> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(DeliveryTermView.All.class)
    @PostMapping
    public DeliveryTerm save(@RequestBody DeliveryTerm deliveryTerm,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {
            deliveryTerm = service.save(deliveryTerm);
            return deliveryTerm;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<DeliveryTerm> deliveryTerms,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {

            service.save(deliveryTerms);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(DeliveryTermView.All.class)
    @GetMapping("/{id}")
    public DeliveryTerm findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.delete(id);
    }

    @JsonView(DeliveryTermView.All.class)
    @PutMapping("/{id}")
    public DeliveryTerm updateCustomer(@PathVariable int id, @RequestBody DeliveryTerm deliveryTerm,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        deliveryTerm.setId(id);
        deliveryTerm = service.save(deliveryTerm);
        return deliveryTerm;
    }
}
