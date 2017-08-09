package com.trendsmixed.fma.module.controlpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;

@Service
public class ControlPointService {

    @Autowired
    private ControlPointRepository repository;

    public Iterable<ControlPoint> findAll() {
        return repository.findAll();
    }

    public Page<ControlPoint> findAll(Pageable pageable) {
        return new Page<ControlPoint>(repository.findAll(pageable));
    }

    public ControlPoint save(ControlPoint ControlPoint) {
        return repository.save(ControlPoint);
    }

    public void save(List<ControlPoint> controlPoints) {
        repository.save(controlPoints);
    }

    public ControlPoint findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public ControlPoint findByCode(String code) {
        return repository.findByCode(code);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }
}
