package com.trendsmixed.fma.module.department;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DepartmentService {

    private DepartmentRepository repository;

    public Iterable<Department> findAll() {
        return repository.findAll();
    }

    public Page<Department> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Department save(Department department) {
        return repository.save(department);
    }

    public void save(List<Department> departments) {
        repository.saveAll(departments);
    }

    public Department findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Department findByCode(String code) {
        return repository.findByCode(code);
    }

    public Department findByName(String name) {
        return repository.findByName(name);
    }
}
