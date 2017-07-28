package com.trendsmixed.fma.module.breakdown;

import com.trendsmixed.fma.utility.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BreakdownService {

    @Autowired
    private BreakdownRepository repository;

    public Iterable<Breakdown> findAll() {
        return repository.findAll();
    }

    public Page<Breakdown> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public Breakdown save(Breakdown breakdown) {
        return repository.save(breakdown);
    }

    public Breakdown findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
}
