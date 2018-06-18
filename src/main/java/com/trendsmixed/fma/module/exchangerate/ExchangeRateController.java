package com.trendsmixed.fma.module.exchangerate;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.currency.Currency;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/exchangeRates")
public class ExchangeRateController {

    
    private final ExchangeRateService service;

    @GetMapping
    @JsonView(ExchangeRateView.AllAndCurrencyAll.class)
    public Iterable<ExchangeRate> findAll() {
        return service.findAll();
    }

    @JsonView(ExchangeRateView.AllAndCurrencyAll.class)
    @GetMapping("/page")
    Page<ExchangeRate> page(Pageable pageable) {
        return new Page<ExchangeRate>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }
    
    @JsonView(ExchangeRateView.AllAndCurrencyAll.class)
    @GetMapping("/currencyAndExchangeRateDate")
    public ExchangeRate getByCurrencyAndExchangeRateDate(
    @RequestParam(value = "currencyId") String currencyId,
            @RequestParam(value = "exchangeRateDate") long exchangeRateDate) {
        return service.findOneByCurrencyAndExchangeRateDate(new Currency(Integer.valueOf(currencyId)), new Date(exchangeRateDate));
    }

    @JsonView(ExchangeRateView.AllAndCurrencyAll.class)
    @GetMapping("/currencyAndExchangeRateDuration")
    public List getByCurrencyAndExchangeRateDuration (
    @RequestParam(value = "currencyId") String currencyId,
    @RequestParam(value = "startDate") long startDate, 
    @RequestParam(value = "endDate") long endDate) {
        return service.findOneByCurrencyAndExchangeRateBetween(new Currency(Integer.valueOf(currencyId)), new Date(startDate), new Date(endDate));
    }

   
    @PostMapping
    @JsonView(ExchangeRateView.AllAndCurrencyAll.class)
    public ExchangeRate save(@RequestBody ExchangeRate exchangeRate) {
        
        try {
           exchangeRate = service.save(exchangeRate);
            return exchangeRate;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ExchangeRate>exchangeRates) {

        
        try {
            service.save( exchangeRates);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ExchangeRateView.AllAndCurrencyAll.class)
    @GetMapping("/{id}")
    public ExchangeRate findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);

    }

    @JsonView(ExchangeRateView.AllAndCurrencyAll.class)
    @PutMapping("/{id}")
    public ExchangeRate updateCustomer(@PathVariable int id, @RequestBody ExchangeRate exchangeRate) {
       exchangeRate.setId(id);
       exchangeRate = service.save(exchangeRate);
        return exchangeRate;
    }

}
