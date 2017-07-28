package com.trendsmixed.fma.module.productionoverheadcostperkg;

import com.trendsmixed.fma.utility.Page;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class ProductionOverheadCostPerKgService {

    @Autowired
    private ProductionOverheadCostPerKgRepository repository;

    public Iterable<ProductionOverheadCostPerKg> findAll() {
        return repository.findAll();
    }

    public Page<ProductionOverheadCostPerKg> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }


    public ProductionOverheadCostPerKg save(ProductionOverheadCostPerKg productionOverheadCostPerKg) {
        return repository.save(productionOverheadCostPerKg);
    }

    public void save(List<ProductionOverheadCostPerKg> countries) {
        repository.save(countries);
    }

    public ProductionOverheadCostPerKg findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
