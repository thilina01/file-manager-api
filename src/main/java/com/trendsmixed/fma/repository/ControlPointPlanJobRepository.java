package com.trendsmixed.fma.repository;

import com.trendsmixed.fma.entity.ControlPointPlanJob;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ControlPointPlanJobRepository extends JpaRepository<ControlPointPlanJob, Integer> {

    @Query(value = "select cppj.controlPointPlan.controlPoint.workCenter.costCenter.section.code as section, sum(cppj.quantity) as quantity "
            + "from ControlPointPlanJob cppj "
            + "where cppj.controlPointPlan.planDate between :startDate and :endDate "
            + "group by cppj.controlPointPlan.controlPoint.workCenter.costCenter.section")
    public ArrayList findSectionWiseQuantityInPlanDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
