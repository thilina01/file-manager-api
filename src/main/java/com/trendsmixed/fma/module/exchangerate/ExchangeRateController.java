package com.trendsmixed.fma.module.exchangerate;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.currency.Currency;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import java.text.ParseException;
import com.trendsmixed.fma.utility.Format;
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

    @JsonView(ExchangeRateView.AllAndCurrencyAll.class)
    @GetMapping(value = "/currencyAndExchangeRateDateBetween")
    public Page<ExchangeRate> getByCurrencyAndExchangeRateDateBetweenPage(
        @RequestParam(value = "currency", required = false, defaultValue = "0") String currency,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<ExchangeRate> page ;

        if(currency.equals("0") ){
            page = new Page(service.findByExchangeRateDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));    
        } 
        else{
            page = new Page(service.findByCurrencyAndExchangeRateDateBetween(new Currency(Integer.valueOf(currency)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        return page;
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
