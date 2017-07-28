package com.trendsmixed.fma.module.salesweight;

import com.trendsmixed.fma.utility.Page;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class SalesWeightService {

    @Autowired
    private SalesWeightRepository repository;

    public Iterable<SalesWeight> findAll() {
        return repository.findAll();
    }

    public Page<SalesWeight> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }


    public SalesWeight save(SalesWeight salesWeight) {
        return repository.save(salesWeight);
    }

    public void save(List<SalesWeight> countries) {
        repository.save(countries);
    }

    public SalesWeight findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
