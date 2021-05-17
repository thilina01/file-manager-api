package com.trendsmixed.fma.module.incoterm;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class IncotermService {

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

    public Incoterm findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Incoterm findByCode(String code) {
        return repository.findByCode(code);
    }

    public Incoterm findByName(String name) {
        return repository.findByName(name);
    }
}
