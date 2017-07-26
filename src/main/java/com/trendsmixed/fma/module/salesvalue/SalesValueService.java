package com.trendsmixed.fma.module.salesvalue;

import com.trendsmixed.fma.entity.SalesValue;
import com.trendsmixed.fma.utility.Page;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class SalesValueService {

    @Autowired
    private SalesValueRepository repository;

    public Iterable<SalesValue> findAll() {
        return repository.findAll();
    }

    public Page<SalesValue> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }


    public SalesValue save(SalesValue salesValue) {
        return repository.save(salesValue);
    }

    public void save(List<SalesValue> countries) {
        repository.save(countries);
    }

    public SalesValue findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
