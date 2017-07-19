package com.trendsmixed.fma.module.incoterm;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.Incoterm;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IncotermService {

    @Autowired
    private IncotermRepository repository;

    public Iterable<Incoterm> findAll() {
        return repository.findAll();
    }

    public Page<Incoterm> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Incoterm save(Incoterm incoterm) {
        return repository.save(incoterm);
    }

    public Incoterm findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Incoterm findByCode(String code) {
        return repository.findByCode(code);
    }

    public Incoterm findByName(String name) {
        return repository.findByName(name);
    }
}
