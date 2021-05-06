package com.trendsmixed.fma.module.salesvalue;

import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SalesValueService {

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

    public void save(List<SalesValue> salesValues) {
        repository.saveAll(salesValues);
    }

    public SalesValue findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
