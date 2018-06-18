package com.trendsmixed.fma.module.currency;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/currencies")
public class CurrencyController {

    
    private final CurrencyService service;

    @JsonView(CurrencyView.All.class)
    @GetMapping
    public Iterable<Currency> findAll() {
        return service.findAll();
    }

    @JsonView(CurrencyView.All.class)
    @GetMapping("/page")
    Page<Currency> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(CurrencyView.All.class)
    @GetMapping("/customer/{id}")
    public Currency findOneByCustomer(@PathVariable("id") int id) {
        return service.findOneByCustomerListId(id);
    }

    @JsonView(CurrencyView.All.class)
    @PostMapping
    public Currency save(@RequestBody Currency currency) {
        
        try {
            currency = service.save(currency);
            return currency;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(CurrencyView.All.class)
    @GetMapping("/{id}")
    public Currency findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @JsonView(CurrencyView.All.class)
    @PutMapping("/{id}")
    public Currency updateCustomer(@PathVariable int id, @RequestBody Currency currency) {
        
        currency.setId(id);
        currency = service.save(currency);
        return currency;
    }
}
