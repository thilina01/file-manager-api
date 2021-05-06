package com.trendsmixed.fma.module.country;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CountryService {

    private CountryRepository repository;

    public Iterable<Country> findAll() {
        return repository.findAll();
    }

    public Page<Country> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Country save(Country country) {
        return repository.save(country);
    }

    public void save(List<Country> countries) {
        repository.saveAll(countries);
    }

    public Country findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Country findByCode(String code) {
        return repository.findByCode(code);
    }

    public Country findByName(String name) {
        return repository.findByName(name);
    }
}
