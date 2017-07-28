package com.trendsmixed.fma.module.producttype;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {

    public ProductType findByCode(String code);

    public ProductType findByDescription(String description);

}
