package com.trendsmixed.fma.module.country;

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
@RequestMapping("/countries")
public class CountryController {

    
    private final CountryService service;

    @JsonView(CountryView.All.class)
    @GetMapping
    public Iterable<Country> findAll() {
        return service.findAll();
    }

    @JsonView(CountryView.All.class)
    @GetMapping("/page")
    Page<Country> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(CountryView.All.class)
    @PostMapping
    public Country save(@RequestBody Country country) {

        
        try {
            country = service.save(country);
            return country;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Country> countries) {

        
        try {
            for (Country country : countries) {
                country.setCode(country.getCode().trim());
                country.setName(country.getName().trim());
                Country existingSection = service.findByCode(country.getCode());
                if (existingSection != null) {
                    country.setId(existingSection.getId());
                }
            }
            service.save(countries);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(CountryView.All.class)
    @GetMapping("/{id}")
    public Country findOne(@PathVariable("id") int id) {
        

        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);
    }

    @JsonView(CountryView.All.class)
    @PutMapping("/{id}")
    public Country updateCustomer(@PathVariable int id, @RequestBody Country country) {
        
        country.setId(id);
        country = service.save(country);
        return country;
    }

}
