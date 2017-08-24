package com.trendsmixed.fma;

import com.trendsmixed.fma.module.country.Country;
import com.trendsmixed.fma.module.currency.Currency;
import com.trendsmixed.fma.module.incoterm.Incoterm;
import com.trendsmixed.fma.module.customertype.CustomerType;
import com.trendsmixed.fma.module.status.Status;
import com.trendsmixed.fma.module.country.CountryService;
import com.trendsmixed.fma.module.currency.CurrencyService;
import com.trendsmixed.fma.module.customertype.CustomerTypeService;
import com.trendsmixed.fma.module.incoterm.IncotermService;
import com.trendsmixed.fma.module.jobtype.JobType;
import com.trendsmixed.fma.module.jobtype.JobTypeService;
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
    private JobTypeService jobTypeService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private IncotermService incotermService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @PostConstruct
    public void afterStarted() {
        System.out.println("Init process started");
        initStatus();
        initCountry();
        initCurrency();
        initIncoterm();
        initJobType();
        initCustomerType();
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
    
    private void initJobType() {
        JobType jobType = jobTypeService.findByCode("Forecast");
        if (jobType == null) {
            jobType = new JobType();
            jobType.setCode("Forecast");
            jobType.setName("Forecast");
            jobTypeService.save(jobType);
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

    private void initCustomerType() {
        CustomerType customerType = customerTypeService.findByCode("NA");
        if (customerType == null) {
            customerType = new CustomerType();
            customerType.setCode("NA");
            customerType.setName("NOT AVAILABLE");
            customerTypeService.save(customerType);
        }
    }
}
