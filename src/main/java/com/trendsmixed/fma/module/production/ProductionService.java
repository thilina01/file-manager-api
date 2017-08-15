package com.trendsmixed.fma.module.production;

import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.shift.Shift;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.utility.Page;

@Service
public class ProductionService {

    @Autowired
    private ProductionRepository repository;

    public Iterable<Production> findAll() {
        return repository.findAll();
    }

    public Page<Production> findAll(Pageable pageable) {
        return new Page<Production>(repository.findAll(pageable));
    }

    public Production save(Production production) {
        return repository.save(production);
    }

    public void save(List<Production> productions) {
        repository.save(productions);
    }

    public Production findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Production findByProductionDateAndShiftAndControlPoint(Date productionDate, Shift shift, ControlPoint controlPoint) {
        return repository.findByProductionDateAndShiftAndControlPoint(productionDate, shift, controlPoint);
    }

}
