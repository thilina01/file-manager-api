package com.trendsmixed.fma.repository;

import com.trendsmixed.fma.entity.CostCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostCenterRepository extends JpaRepository<CostCenter, Integer> {

    public CostCenter findByCode(String code);

}
