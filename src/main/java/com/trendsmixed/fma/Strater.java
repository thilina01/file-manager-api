package com.trendsmixed.fma;

import com.trendsmixed.fma.module.country.Country;
import com.trendsmixed.fma.module.currency.Currency;
import com.trendsmixed.fma.module.designation.Designation;
import com.trendsmixed.fma.module.designation.DesignationService;
import com.trendsmixed.fma.module.employeecategory.EmployeeCategory;
import com.trendsmixed.fma.module.employeecategory.EmployeeCategoryService;
import com.trendsmixed.fma.module.incoterm.Incoterm;
import com.trendsmixed.fma.module.customertype.CustomerType;
import com.trendsmixed.fma.module.labourtursource.LabourSource;
import com.trendsmixed.fma.module.labourtursource.LabourSourceService;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.section.SectionService;
import com.trendsmixed.fma.module.shift.Shift;
import com.trendsmixed.fma.module.shift.ShiftService;
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
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class Strater {

    private final StatusService statusService;
    private final CountryService countryService;
    private final DesignationService designationService;
    private final EmployeeCategoryService employeeCategoryService;
    private final JobTypeService jobTypeService;
    private final CurrencyService currencyService;
    private final IncotermService incotermService;
    private final CustomerTypeService customerTypeService;
    private final LabourSourceService labourSourceService;
    private final SectionService sectionService;
    private final ShiftService shiftService;

    @PostConstruct
    public void afterStarted() {
        System.out.println("Init process started");
        initStatus();
        initCountry();
        initCurrency();
        initIncoterm();
        initJobType();
        initCustomerType();
        initDesignation();
        initEmployeeCategory();
        initLabourSource();
        initSection();
        initShift();
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

    private void initDesignation() {
        Designation designation = designationService.findByCode("NA");
        if (designation == null) {
            designation = new Designation();
            designation.setCode("NA");
            designation.setName("NOT AVAILABLE");
            designationService.save(designation);
        }
    }

    private void initEmployeeCategory() {
        EmployeeCategory employeeCategory = employeeCategoryService.findByCode("NA");
        if (employeeCategory == null) {
            employeeCategory = new EmployeeCategory();
            employeeCategory.setCode("NA");
            employeeCategory.setName("NOT AVAILABLE");
            employeeCategoryService.save(employeeCategory);
        }
    }

    private void initLabourSource() {
        LabourSource labourSource = labourSourceService.findByCode("NA");
        if (labourSource == null) {
            labourSource = new LabourSource();
            labourSource.setCode("NA");
            labourSource.setName("NOT AVAILABLE");
            labourSourceService.save(labourSource);
        }
    }

    private void initSection() {
        Section section = sectionService.findByCode("NA");
        if (section == null) {
            section = new Section();
            section.setCode("NA");
            section.setName("NOT AVAILABLE");
            sectionService.save(section);
        }
    }

    private void initShift() {
        Shift shift = shiftService.findByCode("NA");
        if (shift == null) {
            shift = new Shift();
            shift.setCode("NA");
            shift.setName("NOT AVAILABLE");
            shiftService.save(shift);
        }
    }
}
