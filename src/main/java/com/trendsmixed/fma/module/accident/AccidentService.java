package com.trendsmixed.fma.module.accident;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccidentService {

    @Autowired
    private AccidentRepository repository;

    public Iterable<Accident> findAll() {
        return repository.findAll();
    }

    public Page<Accident> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Accident save(Accident accident) {
        return repository.save(accident);
    }

    public Accident findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Accident findByCode(String code) {
        return repository.findByCode(code);
    }
}
