package com.trendsmixed.fma.module.designation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;

@Service
public class DesignationService {

    @Autowired
    private DesignationRepository repository;

    public Iterable<Designation> findAll() {
        return repository.findAll();
    }

    public Page<Designation> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Designation save(Designation designation) {
        return repository.save(designation);
    }

    public void save(List<Designation> shifts) {
        repository.save(shifts);
    }

    public Designation findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Designation findByName(String name) {
        return repository.findByName(name);
    }
}
