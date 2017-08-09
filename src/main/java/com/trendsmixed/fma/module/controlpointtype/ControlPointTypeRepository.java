package com.trendsmixed.fma.module.controlpointtype;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface ControlPointTypeRepository extends PagingAndSortingRepository<ControlPointType, Integer> {

    public ControlPointType findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(controlPointType.id, controlPointType.code, controlPointType.name)"
            + " FROM ControlPointType controlPointType")
    public List<Combo> getCombo();

}
