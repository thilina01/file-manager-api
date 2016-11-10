package com.trendsmixed.fma.repository;

import com.trendsmixed.fma.entity.LossType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LossTypeRepository extends JpaRepository<LossType, Integer> {

    public LossType findByCode(String code);

}
