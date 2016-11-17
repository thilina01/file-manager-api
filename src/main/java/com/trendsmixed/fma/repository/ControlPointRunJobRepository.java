package com.trendsmixed.fma.repository;

import com.trendsmixed.fma.entity.ControlPointRunJob;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ControlPointRunJobRepository extends JpaRepository<ControlPointRunJob, Integer> {

    @Query(value = "select cppj.controlPointRun.controlPoint.workCenter.costCenter.section.code as section, sum(cppj.quantity) as quantity "
            + "from ControlPointRunJob cppj "
            + "where cppj.controlPointRun.runDate between :startDate and :endDate "
            + "group by cppj.controlPointRun.controlPoint.workCenter.costCenter.section ")
    public ArrayList findSectionWiseQuantityInRunDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
