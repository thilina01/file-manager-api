package com.trendsmixed.fma.module.productionoverheadcostperkg;

import com.trendsmixed.fma.utility.Page;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductionOverheadCostPerKgService {

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

    public void save(List<ProductionOverheadCostPerKg> productionOverheadCostPerKgs) {
        repository.saveAll(productionOverheadCostPerKgs);
    }

    public ProductionOverheadCostPerKg findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
