package com.trendsmixed.fma.controller;

import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.Currency;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.CurrencyService;
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
@RequestMapping("/currencies")
public class CurrencyController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private CurrencyService currencyService;

    @PostMapping
    public Currency save(@RequestBody Currency currency, @RequestHeader(value = "email", defaultValue = "") String email) {
        AppSession appSession = appSessionService.findOne(email);
        if (appSession == null) {
            throw new Error("Unauthorized access");
        } else {
            try {
                currency = currencyService.save(currency);
                return currency;

            } catch (Throwable e) {
                while (e.getCause() != null) {
                    e = e.getCause();
                }
                throw new Error(e.getMessage());
            }
        }
    }

    @GetMapping
    public List<Currency> findAll() {
        return currencyService.findAll();
    }

    @GetMapping("/{id}")
    public Currency findOne(@PathVariable("id") int id) {
        return currencyService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable int id) {
        currencyService.delete(id);
        return "Deleted";

    }

    @PutMapping("/{id}")
    public Currency updateCustomer(@PathVariable int id, @RequestBody Currency currency) {
        currency.setId(id);
        currency = currencyService.save(currency);
        return currency;
    }
}
