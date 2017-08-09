package com.trendsmixed.fma.module.cumulativesalesperkg;

import com.trendsmixed.fma.utility.Page;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CumulativeSalesPerKgService {

    @Autowired
    private CumulativeSalesPerKgRepository repository;

    public Iterable<CumulativeSalesPerKg> findAll() {
        return repository.findAll();
    }

    public Page<CumulativeSalesPerKg> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public CumulativeSalesPerKg save(CumulativeSalesPerKg cumulativeSalesPerKg) {
        return repository.save(cumulativeSalesPerKg);
    }

    public void save(List<CumulativeSalesPerKg> countries) {
        repository.save(countries);
    }

    public CumulativeSalesPerKg findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
