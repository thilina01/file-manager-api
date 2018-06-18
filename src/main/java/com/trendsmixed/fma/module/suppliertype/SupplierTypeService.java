package com.trendsmixed.fma.module.suppliertype;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void save(List<SupplierType> supplierTypes) {
        repository.save(supplierTypes);
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
