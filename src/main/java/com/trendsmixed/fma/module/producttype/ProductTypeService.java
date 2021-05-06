package com.trendsmixed.fma.module.producttype;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductTypeService {

    private ProductTypeRepository repository;

    public Iterable<ProductType> findAll() {
        return repository.findAll();
    }

    public Page<ProductType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public ProductType save(ProductType productType) {
        return repository.save(productType);
    }

    public void save(List<ProductType> productTypes) {
        repository.saveAll(productTypes);
    }

    public ProductType findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public ProductType findByCode(String code) {
        return repository.findByCode(code);
    }

}
