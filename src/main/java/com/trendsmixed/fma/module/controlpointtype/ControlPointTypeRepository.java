package com.trendsmixed.fma.module.controlpointtype;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trendsmixed.fma.entity.ControlPointType;

public interface ControlPointTypeRepository extends JpaRepository<ControlPointType, Integer> {

    public ControlPointType findByCode(String code);

}
