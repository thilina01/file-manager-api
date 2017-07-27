package com.trendsmixed.fma.module.materialcostperkg;

import com.trendsmixed.fma.entity.MaterialCostPerKg;
import com.trendsmixed.fma.utility.Page;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class MaterialCostPerKgService {

    @Autowired
    private MaterialCostPerKgRepository repository;

    public Iterable<MaterialCostPerKg> findAll() {
        return repository.findAll();
    }

    public Page<MaterialCostPerKg> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }


    public MaterialCostPerKg save(MaterialCostPerKg materialCostPerKg) {
        return repository.save(materialCostPerKg);
    }

    public void save(List<MaterialCostPerKg> countries) {
        repository.save(countries);
    }

    public MaterialCostPerKg findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
