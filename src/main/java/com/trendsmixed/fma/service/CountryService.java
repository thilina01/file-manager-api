package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.Country;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country save(Country country) {
        return countryRepository.save(country);
    }

    public void save(List<Country> countries) {
        countryRepository.save(countries);
    }

    public Country findOne(int id) {
        return countryRepository.findOne(id);
    }

    public void delete(int id) {
        countryRepository.delete(id);
    }

    public Country findByCode(String code) {    
        return countryRepository.findByCode(code);
    }
}
