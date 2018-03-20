package com.trendsmixed.fma.module.section;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.repository.query.Param;

public interface SectionRepository extends PagingAndSortingRepository<Section, Integer> {

    Section findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Section o")
    List<Combo> getCombo();
//
//    @Query(value = "SELECT"
//            + " production.controlPoint.workCenter.costCenter.section"
//            + " FROM Production production"
//            + " WHERE production.controlPoint.workCenter.costCenter.section = :section AND production.productionDate = :productionDate ")
//    Section test(@Param("section") Section section,@Param("productionDate") Date productionDate);

    Section findByIdAndCostCenterListWorkCenterListControlPointListProductionListProductionDate(int id, Date productionDate);

}
