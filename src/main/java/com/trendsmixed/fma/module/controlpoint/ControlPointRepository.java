package com.trendsmixed.fma.module.controlpoint;

import com.trendsmixed.fma.entity.ControlPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ControlPointRepository extends JpaRepository<ControlPoint, Integer> {

    public ControlPoint findByCode(String code);

}
