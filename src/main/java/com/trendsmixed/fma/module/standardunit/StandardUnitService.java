package com.trendsmixed.fma.module.standardunit;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StandardUnitService {

    private StandardUnitRepository repository;

    public Iterable<StandardUnit> findAll() {
        return repository.findAll();
    }

    public Page<StandardUnit> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public StandardUnit save(StandardUnit standardUnit) {
        return repository.save(standardUnit);
    }

    public void save(List<StandardUnit> standardUnits) {
        repository.save(standardUnits);
    }

    public StandardUnit findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public StandardUnit findByName(String name) {
        return repository.findByName(name);
    }
}
