package com.trendsmixed.fma.module.designationtype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;

@Service
public class DesignationTypeService {

    @Autowired
    private DesignationTypeRepository repository;

    public Iterable<DesignationType> findAll() {
        return repository.findAll();
    }

    public Page<DesignationType> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public DesignationType save(DesignationType designationType) {
        return repository.save(designationType);
    }

    public void save(List<DesignationType> shifts) {
        repository.save(shifts);
    }

    public DesignationType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public DesignationType findByName(String name) {
        return repository.findByName(name);
    }
}
