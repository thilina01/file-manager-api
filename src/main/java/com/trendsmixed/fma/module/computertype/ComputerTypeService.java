package com.trendsmixed.fma.module.computertype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.domain.Page;

@Service
public class ComputerTypeService {

    @Autowired
    private ComputerTypeRepository repository;

    public Iterable<ComputerType> findAll() {
        return repository.findAll();
    }

    public Page<ComputerType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public ComputerType save(ComputerType computerType) {
        return repository.save(computerType);
    }

    public void save(List<ComputerType> items) {
        repository.save(items);
    }

    public ComputerType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public ComputerType findByName(String name) {
        return repository.findByName(name);
    }
}
