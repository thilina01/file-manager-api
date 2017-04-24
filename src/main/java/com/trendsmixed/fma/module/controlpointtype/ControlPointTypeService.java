package com.trendsmixed.fma.module.controlpointtype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.entity.ControlPointType;

@Service
public class ControlPointTypeService {

    @Autowired
    private ControlPointTypeRepository repository;

    public List<ControlPointType> findAll() {
        return repository.findAll();
    }

    public ControlPointType save(ControlPointType controlPointType) {
        return repository.save(controlPointType);
    }

    public void save(List<ControlPointType> controlPointTypes) {
        repository.save(controlPointTypes);
    }

    public ControlPointType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public ControlPointType findByCode(String code) {
        return repository.findByCode(code);
    }
}
