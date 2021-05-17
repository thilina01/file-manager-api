package com.trendsmixed.fma.module.paymentterm;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/paymentTerms")
public class PaymentTermController {

    private AppSessionService appSessionService;
    private PaymentTermService service;

    @JsonView(PaymentTermView.All.class)
    @GetMapping
    public Iterable<PaymentTerm> findAll() {
        return service.findAll();
    }

    @JsonView(PaymentTermView.All.class)
    @GetMapping("/page")
    Page<PaymentTerm> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(PaymentTermView.All.class)
    @PostMapping
    public PaymentTerm save(@RequestBody PaymentTerm paymentTerm) {
        
        try {
            paymentTerm = service.save(paymentTerm);
            return paymentTerm;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(PaymentTermView.All.class)
    @GetMapping("/{id}")
    public PaymentTerm findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @JsonView(PaymentTermView.All.class)
    @PutMapping("/{id}")
    public PaymentTerm updateCustomer(@PathVariable int id, @RequestBody PaymentTerm paymentTerm) {
        
        paymentTerm.setId(id);
        paymentTerm = service.save(paymentTerm);
        return paymentTerm;
    }
}
