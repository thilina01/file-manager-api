package com.trendsmixed.fma.module.controlpoint;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ControlPointRepository extends PagingAndSortingRepository<ControlPoint, Integer> {

    ControlPoint findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(controlPoint.id, controlPoint.code, controlPoint.name)"
            + " FROM ControlPoint controlPoint")
    List<Combo> getCombo();

}
