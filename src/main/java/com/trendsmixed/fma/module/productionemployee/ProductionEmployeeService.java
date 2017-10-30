package com.trendsmixed.fma.module.productionemployee;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@Service
public class ProductionEmployeeService {

    private ProductionEmployeeRepository repository;

    public Iterable<ProductionEmployee> findAll() {
        return repository.findAll();
    }

    public Page<ProductionEmployee> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public ProductionEmployee save(ProductionEmployee productionEmployee) {
        return repository.save(productionEmployee);
    }

    public void save(List<ProductionEmployee> items) {
        repository.save(items);
    }

    public ProductionEmployee findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    
}

