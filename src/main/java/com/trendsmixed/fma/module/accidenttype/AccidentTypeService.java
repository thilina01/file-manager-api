package com.trendsmixed.fma.module.accidenttype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.domain.Page;

@Service
public class AccidentTypeService {

    @Autowired
    private AccidentTypeRepository repository;

    public Iterable<AccidentType> findAll() {
        return repository.findAll();
    }

    public Page<AccidentType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public AccidentType save(AccidentType accidentType) {
        return repository.save(accidentType);
    }

    public void save(List<AccidentType> items) {
        repository.save(items);
    }

    public AccidentType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public AccidentType findByName(String name) {
        return repository.findByName(name);
    }
}
