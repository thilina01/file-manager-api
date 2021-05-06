package com.trendsmixed.fma.module.employee;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {

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

    public void save(List<Employee> employees) {
        repository.saveAll(employees);
    }

    public Employee findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Employee findByCode(String code) {
        return repository.findByCode(code);
    }
    public Employee findOneByCustomerListId(int id) {
        return repository.findOneByCustomerListId(id);
    }

}
