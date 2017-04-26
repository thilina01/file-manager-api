package com.trendsmixed.fma.module.country;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.Country;
import com.trendsmixed.fma.module.country.CountryView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private CountryService countryService;

    @JsonView(CountryView.All.class)
    @GetMapping
    public List<Country> findAll() {
        return countryService.findAll();
    }

    @PostMapping
    public Country save(@RequestBody Country country, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            country = countryService.save(country);
            return country;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Country> countries, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            for (Country country : countries) {
                country.setCode(country.getCode().trim());
                country.setName(country.getName().trim());
                Country existingSection = countryService.findByCode(country.getCode());
                if (existingSection != null) {
                    country.setId(existingSection.getId());
                }
            }
            countryService.save(countries);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Country findOne(@PathVariable("id") int id) {
        return countryService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        countryService.delete(id);

    }

    @PutMapping("/{id}")
    public Country updateCustomer(@PathVariable int id, @RequestBody Country country, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        country.setId(id);
        country = countryService.save(country);
        return country;
    }

}