package com.trendsmixed.fma.module.accidenttype;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AccidentTypeService {

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

    public void save(List<AccidentType> accidentTypes) {
        repository.save(accidentTypes);
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
