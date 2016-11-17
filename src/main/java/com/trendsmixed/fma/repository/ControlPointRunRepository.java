package com.trendsmixed.fma.repository;

import com.trendsmixed.fma.entity.ControlPoint;
import com.trendsmixed.fma.entity.ControlPointRun;
import com.trendsmixed.fma.entity.Shift;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ControlPointRunRepository extends JpaRepository<ControlPointRun, Integer> {

    public ControlPointRun findByRunDateAndControlPointAndShift(Date runDate, ControlPoint controlPoint, Shift shift);

    public List<ControlPointRun> findByRunDateBetween(Date startDate, Date endDate);

    public List<ControlPointRun> findByRunDateBetweenOrderByRunDate(Date startDate, Date endDate);

    public List<ControlPointRun> findControlPointDistinctByRunDateBetweenOrderByRunDate(Date startDate, Date endDate);

    public long countControlPointDistinctByRunDateBetweenOrderByRunDate(Date startDate, Date endDate);

    @Query(value = "select cpr.controlPoint.workCenter.costCenter.section.code, (sum(cpr.breakdownDuration) / sum(breakdownCount)) as mttr "
            + "from ControlPointRun cpr "
            + "where cpr.runDate between :startDate and :endDate "
            + "group by cpr.controlPoint.workCenter.costCenter.section ")
    public ArrayList findSectionWiseMttrDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "select cpr.controlPoint.workCenter.costCenter.section.code, (sum(cpr.workingDuration) / sum(breakdownCount)) as mtbf "
            + "from ControlPointRun cpr "
            + "where cpr.runDate between :startDate and :endDate "
            + "group by cpr.controlPoint.workCenter.costCenter.section ")
    public ArrayList findSectionWiseMtbfDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "select cpr.controlPoint.workCenter.costCenter.section.code, ((sum(breakdownDuration) / sum(workingDuration))*100) as mdt "
            + "from ControlPointRun cpr "
            + "where cpr.runDate between :startDate and :endDate "
            + "group by cpr.controlPoint.workCenter.costCenter.section ")
    public ArrayList findSectionWiseMdtDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
