package com.trendsmixed.fma.module.supplier;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SupplierService {

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
        repository.saveAll(suppliers);
    }

    public Supplier findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Supplier findByCode(String code) {
        return repository.findByCode(code);
    }
}
