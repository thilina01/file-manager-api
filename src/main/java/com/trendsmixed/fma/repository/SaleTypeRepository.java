package com.trendsmixed.fma.repository;

import com.trendsmixed.fma.entity.SaleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleTypeRepository extends JpaRepository<SaleType, Integer> {

    public SaleType findByCode(String code);

    public SaleType findByName(String name);

}
