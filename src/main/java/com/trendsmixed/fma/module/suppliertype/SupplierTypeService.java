package com.trendsmixed.fma.module.suppliertype;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@Service
public class SupplierTypeService {

    private SupplierTypeRepository repository;

    public Iterable<SupplierType> findAll() {
        return repository.findAll();
    }

    public Page<SupplierType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SupplierType save(SupplierType supplierType) {
        return repository.save(supplierType);
    }

    public void save(List<SupplierType> items) {
        repository.save(items);
    }

    public SupplierType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public SupplierType findByName(String name) {
        return repository.findByName(name);
    }
}
