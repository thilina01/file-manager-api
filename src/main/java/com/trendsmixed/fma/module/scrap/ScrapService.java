package com.trendsmixed.fma.module.scrap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;

@Service
public class ScrapService {

    @Autowired
    private ScrapRepository repository;

    public Iterable<Scrap> findAll() {
        return repository.findAll();
    }

    public Page<Scrap> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Scrap save(Scrap scrap) {
        return repository.save(scrap);
    }

    public void save(List<Scrap> scraps) {
        repository.save(scraps);
    }

    public Scrap findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
}
