package com.trendsmixed.fma.module.producttype;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService {

    @Autowired
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

    public void save(List<ProductType> countries) {
        repository.save(countries);
    }

    public ProductType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public ProductType findByCode(String code) {
        return repository.findByCode(code);
    }

}
