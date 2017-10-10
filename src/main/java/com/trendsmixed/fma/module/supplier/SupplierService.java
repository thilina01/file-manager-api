package com.trendsmixed.fma.module.supplier;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository repository;

    public Iterable<Supplier> findAll() {
        return repository.findAll();
    }

    public Page<Supplier> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Supplier save(Supplier supplier) {
        return repository.save(supplier);
    }

    public void save(List<Supplier> suppliers) {
        repository.save(suppliers);
    }

    public Supplier findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Supplier findByCode(String code) {
        return repository.findByCode(code);
    }
}