package com.trendsmixed.fma.module.chart;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trendsmixed.fma.entity.LossReason;
import com.trendsmixed.fma.entity.LossType;
import com.trendsmixed.fma.entity.Section;

public interface ChartRepository extends JpaRepository<com.trendsmixed.fma.entity.Query, Integer> {

    @Query(value = "SELECT x.section as section, x.run_duration_h, y.breakdown_duration_h, z.breakdown_count, "
            + "	ROUND(x.run_duration_h/z.breakdown_count,2) AS MTBF, "
            + "	ROUND(y.breakdown_duration_h/z.breakdown_count,2) AS MTTR, "
            + "	ROUND(y.breakdown_duration_h/x.run_duration_h,4)*100 AS MDT, "
            + "    x.mtbf_target, x.mttr_target, x.mdt_target "
            + "FROM ( "
            + "SELECT section.code AS section, section.mtbf_target AS mtbf_target, section.mttr_target AS mttr_target, section.mdt_target AS mdt_target, ROUND(SUM(`actual_duration`)/60,2) AS run_duration_h "
            + "FROM `production`  "
            + "INNER JOIN control_point ON `control_point_id` = control_point.id "
            + "INNER JOIN work_center ON control_point.work_center_id = work_center.id "
            + "INNER JOIN cost_center ON work_center.cost_center_id = cost_center.id "
            + "INNER JOIN section ON cost_center.section_id = section.id "
            + "WHERE `production_date` BETWEEN  ?1 AND  ?2 "
            + "GROUP BY section.id) AS x LEFT JOIN "
            + "(SELECT section.code AS section,  "
            + "ROUND(SUM(TIMESTAMPDIFF(SECOND,breakdown.breakdown_time,breakdown.recovery_time))/3600,2) AS breakdown_duration_h "
            + "FROM `control_point_machine`  "
            + "INNER JOIN control_point ON `control_point_id` = control_point.id "
            + "INNER JOIN work_center ON control_point.work_center_id = work_center.id "
            + "INNER JOIN cost_center ON work_center.cost_center_id = cost_center.id "
            + "INNER JOIN section ON cost_center.section_id = section.id "
            + "INNER JOIN machine ON machine_id = machine.id "
            + "INNER JOIN breakdown ON breakdown.machine_id = machine.id "
            + "WHERE breakdown.breakdown_time BETWEEN  ?1 AND  ?2 "
            + "GROUP BY section.id) AS y ON  "
            + "x.section = y.section  LEFT JOIN "
            + "(SELECT section.code AS section,  "
            + "count(breakdown.id) AS breakdown_count "
            + "FROM `control_point_machine`  "
            + "INNER JOIN control_point ON `control_point_id` = control_point.id "
            + "INNER JOIN work_center ON control_point.work_center_id = work_center.id "
            + "INNER JOIN cost_center ON work_center.cost_center_id = cost_center.id "
            + "INNER JOIN section ON cost_center.section_id = section.id "
            + "INNER JOIN machine ON machine_id = machine.id "
            + "INNER JOIN breakdown ON breakdown.machine_id = machine.id "
            + "WHERE breakdown.breakdown_time BETWEEN  ?1 AND  ?2 "
            + "GROUP BY section.id) AS z ON  "
            + "x.section = z.section", nativeQuery = true)
    public List getBreakdown(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	@Query(value = "SELECT "
			+ " controlPointMachine.controlPoint.workCenter.costCenter.section.code , (SUM((breakdown.recoveryTime - breakdown.breakdownTime)*0.6))/60 "
			+ " FROM ControlPointMachine controlPointMachine, Breakdown breakdown" 
			+ " JOIN controlPointMachine.machine machine" 
			+ " WHERE machine = breakdown.machine AND breakdown.breakdownTime BETWEEN :startDate AND :endDate"
			+ " GROUP BY controlPointMachine.controlPoint.workCenter.costCenter.section")
	public List test(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
//	@Query(value = "SELECT "
//			+ " production.controlPoint.workCenter.costCenter.section.code , SUM(production.actualDuration) "
//			+ " FROM Production production" + " WHERE production.productionDate BETWEEN :startDate AND :endDate"
//			+ " GROUP BY production.controlPoint.workCenter.costCenter.section")
//	public List getTotalProductonDurationGroupedBySecton(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.ScheduleAdherence(operation.production.controlPoint.workCenter.costCenter.section.code, SUM(operation.actualQuantity), SUM(operation.plannedQuantity), (SUM(operation.actualQuantity)/SUM(operation.plannedQuantity))*100) "
            + " FROM Operation operation" + " WHERE operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " GROUP BY operation.production.controlPoint.workCenter.costCenter.section")
    public List getScheduleAdherence(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.ScheduleAdherence(operation.production.productionDate, SUM(operation.actualQuantity), SUM(operation.plannedQuantity), (SUM(operation.actualQuantity)/SUM(operation.plannedQuantity))*100) "
            + " FROM Operation operation"
            + " WHERE operation.production.controlPoint.workCenter.costCenter.section = :section AND operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " GROUP BY operation.production.productionDate")
    public List getScheduleAdherenceBySection(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("section") Section section);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonSummary(loss.lossReason.id,loss.lossReason.code,loss.lossReason.reason, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE loss.operation.production.controlPoint.workCenter.costCenter.section = :section AND operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " GROUP BY loss.lossReason" + " ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonSummaryBySection(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("section") Section section);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonSummary(loss.lossReason.id,loss.lossReason.code,loss.lossReason.reason, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE loss.lossReason.lossType = :lossType AND operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " GROUP BY loss.lossReason" + " ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonSummaryByLossType(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("lossType") LossType lossType);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonSummary(loss.lossReason.id,loss.lossReason.code,loss.lossReason.reason, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " GROUP BY loss.lossReason" + " ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonSummary(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonDailyCount(operation.production.productionDate, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE loss.operation.production.controlPoint.workCenter.costCenter.section = :section AND operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " GROUP BY operation.production.productionDate ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonDailyCountBySection(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("section") Section section);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonDailyCount(operation.production.productionDate, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE  loss.lossReason.lossType = :lossType AND operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " GROUP BY operation.production.productionDate ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonDailyCountByLossType(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("lossType") LossType lossType);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonDailyCount(operation.production.productionDate, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE  loss.lossReason.lossType = :lossType AND loss.operation.production.controlPoint.workCenter.costCenter.section = :section AND operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " GROUP BY operation.production.productionDate ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonDailyCountBySectionAndLossType(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("section") Section section,
            @Param("lossType") LossType lossType);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonDailyCount(operation.production.productionDate, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " GROUP BY operation.production.productionDate ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonDailyCount(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonDailyCount(operation.production.productionDate, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE loss.lossReason = :lossReason AND loss.operation.production.controlPoint.workCenter.costCenter.section = :section AND operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " GROUP BY operation.production.productionDate ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonDailyCountBySectionAndLossReason(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("section") Section section,
            @Param("lossReason") LossReason lossReason);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonDailyCount(operation.production.productionDate, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE loss.lossReason = :lossReason AND operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " GROUP BY operation.production.productionDate ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonDailyCountByLossReason(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("lossReason") LossReason lossReason);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonSummary(loss.lossReason.id,loss.lossReason.code,loss.lossReason.reason, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE loss.lossReason.lossType = :lossType AND loss.operation.production.controlPoint.workCenter.costCenter.section = :section AND operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " GROUP BY loss.lossReason ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonSummaryBySectionAndLossType(@Param("startDate") Date startDate,
            @Param("endDate") Date endDate, @Param("section") Section section, @Param("lossType") LossType lossType);

}
