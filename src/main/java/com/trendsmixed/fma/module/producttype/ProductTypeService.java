package com.trendsmixed.fma.module.producttype;

import com.trendsmixed.fma.entity.ProductType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.module.producttype.ProductTypeRepository;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    public ProductType save(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    public void save(List<ProductType> productTypes) {
        productTypeRepository.save(productTypes);
    }

    public ProductType findOne(int id) {
        return productTypeRepository.findOne(id);
    }

    public void delete(int id) {
        productTypeRepository.delete(id);
    }

    public ProductType findByCode(String code) {
        return productTypeRepository.findByCode(code);
    }

    public ProductType findByDescription(String description) {
        return productTypeRepository.findByDescription(description);
    }
}
