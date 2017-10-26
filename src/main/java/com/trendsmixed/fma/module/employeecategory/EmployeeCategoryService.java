package com.trendsmixed.fma.module.employeecategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;

@Service
public class EmployeeCategoryService {

    @Autowired
    private EmployeeCategoryRepository repository;

    public Iterable<EmployeeCategory> findAll() {
        return repository.findAll();
    }

    public Page<EmployeeCategory> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public EmployeeCategory save(EmployeeCategory employeeCategory) {
        return repository.save(employeeCategory);
    }

    public void save(List<EmployeeCategory> shifts) {
        repository.save(shifts);
    }

    public EmployeeCategory findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public EmployeeCategory findByName(String name) {
        return repository.findByName(name);
    }
}
