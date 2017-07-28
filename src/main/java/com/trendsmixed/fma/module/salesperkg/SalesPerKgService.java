package com.trendsmixed.fma.module.salesperkg;

import com.trendsmixed.fma.utility.Page;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class SalesPerKgService {

    @Autowired
    private SalesPerKgRepository repository;

    public Iterable<SalesPerKg> findAll() {
        return repository.findAll();
    }

    public Page<SalesPerKg> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }


    public SalesPerKg save(SalesPerKg salesPerKg) {
        return repository.save(salesPerKg);
    }

    public void save(List<SalesPerKg> countries) {
        repository.save(countries);
    }

    public SalesPerKg findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
