package com.trendsmixed.fma.module.warehouse;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class WarehouseService {

    private WarehouseRepository repository;

    public Iterable<Warehouse> findAll() {
        return repository.findAll();
    }

    public Page<Warehouse> findAll(Pageable pageable) {
        return new Page<Warehouse>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Warehouse save(Warehouse warehouse) {
        return repository.save(warehouse);
    }

    public Warehouse findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Warehouse findByCode(String code) {
        return repository.findByCode(code);
    }
}
