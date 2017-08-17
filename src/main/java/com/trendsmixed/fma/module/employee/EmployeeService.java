package com.trendsmixed.fma.module.employee;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Iterable<Employee> findAll() {
        return repository.findAll();
    }

    public Page<Employee> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public void save(List<Employee> countries) {
        repository.save(countries);
    }

    public Employee findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Employee findByCode(String code) {
        return repository.findByCode(code);
    }

}
