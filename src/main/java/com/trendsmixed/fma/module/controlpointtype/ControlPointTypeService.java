package com.trendsmixed.fma.module.controlpointtype;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ControlPointTypeService {

    private ControlPointTypeRepository repository;

    public Iterable<ControlPointType> findAll() {
        return repository.findAll();
    }

    public Page<ControlPointType> findAll(Pageable pageable) {
        return new Page<ControlPointType>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
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
