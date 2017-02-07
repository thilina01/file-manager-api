package com.trendsmixed.fma;

import com.trendsmixed.fma.entity.Country;
import com.trendsmixed.fma.entity.Currency;
import com.trendsmixed.fma.entity.Incoterm;
import com.trendsmixed.fma.entity.SaleType;
import com.trendsmixed.fma.entity.Status;
import com.trendsmixed.fma.module.country.CountryService;
import com.trendsmixed.fma.module.currency.CurrencyService;
import com.trendsmixed.fma.module.incoterm.IncotermService;
import com.trendsmixed.fma.module.saletype.SaleTypeService;
import com.trendsmixed.fma.module.status.StatusService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Strater {

    @Autowired
    private StatusService statusService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private IncotermService incotermService;
    @Autowired
    private SaleTypeService saleTypeService;

    @PostConstruct
    public void afterStarted() {
        System.out.println("Init process started");
        initStatus();
        initCountry();
        initCurrency();
        initIncoterm();
        initSaleType();
        System.out.println("Init process finished");
    }

    private void initStatus() {
        List<Status> statuses = statusService.findAll();
        if (statuses.isEmpty()) {
            Status active = new Status();
            active.setName("active");
            Status inactive = new Status();
            inactive.setName("inactive");

            statuses.add(active);
            statuses.add(inactive);

            statusService.save(statuses);
        }
    }

    private void initCountry() {
        Country country = countryService.findByCode("NA");
        if (country == null) {
            country = new Country();
            country.setCode("NA");
            country.setName("NOT AVAILABLE");
            countryService.save(country);
        }
    }

    private void initCurrency() {
        Currency currency = currencyService.findByCode("NA");
        if (currency == null) {
            currency = new Currency();
            currency.setCode("NA");
            currency.setName("NOT AVAILABLE");
            currencyService.save(currency);
        }
    }

    private void initIncoterm() {
        Incoterm incoterm = incotermService.findByCode("NA");
        if (incoterm == null) {
            incoterm = new Incoterm();
            incoterm.setCode("NA");
            incoterm.setName("NOT AVAILABLE");
            incotermService.save(incoterm);
        }
    }
    
    private void initSaleType() {
        SaleType saleType = saleTypeService.findByCode("NA");
        if (saleType == null) {
            saleType = new SaleType();
            saleType.setCode("NA");
            saleType.setName("NOT AVAILABLE");
            saleTypeService.save(saleType);
        }
    }
}
