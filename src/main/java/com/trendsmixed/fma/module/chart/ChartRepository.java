package com.trendsmixed.fma.module.chart;

import com.trendsmixed.fma.module.location.Location;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trendsmixed.fma.module.lossreason.LossReason;
import com.trendsmixed.fma.module.losstype.LossType;
import com.trendsmixed.fma.module.section.Section;

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
            + " FROM Operation operation"
            + " WHERE operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " AND operation.production.controlPoint.controlPointType.id=1"
            + " AND operation.actualQuantity > 0"
            + " GROUP BY operation.production.controlPoint.workCenter.costCenter.section")
    public List getScheduleAdherence(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.ScheduleAdherence(operation.production.productionDate, SUM(operation.actualQuantity), SUM(operation.plannedQuantity), (SUM(operation.actualQuantity)/SUM(operation.plannedQuantity))*100) "
            + " FROM Operation operation"
            + " WHERE operation.production.controlPoint.workCenter.costCenter.section = :section"
            + " AND operation.production.controlPoint.controlPointType.id=1"
            + " AND operation.actualQuantity > 0"
            + " AND operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " GROUP BY operation.production.productionDate")
    public List getScheduleAdherenceBySection(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("section") Section section);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonSummary(loss.lossReason.id,loss.lossReason.code,loss.lossReason.name, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE loss.operation.production.controlPoint.workCenter.costCenter.section = :section"
            + " AND operation.production.controlPoint.controlPointType.id=1"
            + " AND operation.actualQuantity > 0"
            + " AND operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " GROUP BY loss.lossReason" + " ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonSummaryBySection(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("section") Section section);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonSummary(loss.lossReason.id,loss.lossReason.code,loss.lossReason.name, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE loss.lossReason.lossType = :lossType AND operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " GROUP BY loss.lossReason" + " ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonSummaryByLossType(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("lossType") LossType lossType);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonSummary(loss.lossReason.id,loss.lossReason.code,loss.lossReason.name, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " AND operation.actualQuantity > 0"
            + " GROUP BY loss.lossReason" + " ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonSummary(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonDailyCount(operation.production.productionDate, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE loss.operation.production.controlPoint.workCenter.costCenter.section = :section AND operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " AND operation.actualQuantity > 0"
            + " GROUP BY operation.production.productionDate ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonDailyCountBySection(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("section") Section section);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonDailyCount(operation.production.productionDate, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE  loss.lossReason.lossType = :lossType AND operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " AND operation.actualQuantity > 0"
            + " GROUP BY operation.production.productionDate ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonDailyCountByLossType(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("lossType") LossType lossType);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonDailyCount(operation.production.productionDate, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE  loss.lossReason.lossType = :lossType AND loss.operation.production.controlPoint.workCenter.costCenter.section = :section AND operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " AND operation.actualQuantity > 0"
            + " GROUP BY operation.production.productionDate ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonDailyCountBySectionAndLossType(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("section") Section section,
            @Param("lossType") LossType lossType);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonDailyCount(operation.production.productionDate, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " AND operation.actualQuantity > 0"
            + " GROUP BY operation.production.productionDate ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonDailyCount(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonDailyCount(operation.production.productionDate, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE loss.lossReason = :lossReason AND loss.operation.production.controlPoint.workCenter.costCenter.section = :section AND operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " AND operation.actualQuantity > 0"
            + " GROUP BY operation.production.productionDate ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonDailyCountBySectionAndLossReason(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("section") Section section,
            @Param("lossReason") LossReason lossReason);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonDailyCount(operation.production.productionDate, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE loss.lossReason = :lossReason AND operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " AND operation.actualQuantity > 0"
            + " GROUP BY operation.production.productionDate ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonDailyCountByLossReason(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
            @Param("lossReason") LossReason lossReason);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.LossReasonSummary(loss.lossReason.id,loss.lossReason.code,loss.lossReason.name, SUM(loss.quantity)) "
            + " FROM Loss loss"
            + " WHERE loss.lossReason.lossType = :lossType AND loss.operation.production.controlPoint.workCenter.costCenter.section = :section AND operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " AND operation.actualQuantity > 0"
            + " GROUP BY loss.lossReason ORDER BY SUM(loss.quantity) DESC")
    public List getLossReasonSummaryBySectionAndLossType(@Param("startDate") Date startDate,
            @Param("endDate") Date endDate, @Param("section") Section section, @Param("lossType") LossType lossType);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.MonthlyScheduleAdherence(DATE_FORMAT(operation.production.productionDate,'%Y-%m'), SUM(operation.actualQuantity), SUM(operation.plannedQuantity), (SUM(operation.actualQuantity)/SUM(operation.plannedQuantity))*100) "
            + " FROM Operation operation"
            + " WHERE operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " AND operation.actualQuantity > 0"
            + " GROUP BY DATE_FORMAT(operation.production.productionDate,'%Y-%m')")
    public List getMonthlyScheduleAdherence(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.MonthlyScheduleAdherence(DATE_FORMAT(operation.production.productionDate,'%Y-%m'), SUM(operation.actualQuantity), SUM(operation.plannedQuantity), (SUM(operation.actualQuantity)/SUM(operation.plannedQuantity))*100) "
            + " FROM Operation operation"
            + " WHERE operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " AND operation.production.controlPoint.workCenter.costCenter.section= :section"
            + " AND operation.actualQuantity > 0"
            + " GROUP BY DATE_FORMAT(operation.production.productionDate,'%Y-%m')")
    public List getMonthlyScheduleAdherenceBySection(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("section") Section section);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.MonthlyEnergyConsumption(DATE_FORMAT(energyConsumption.effectiveMonth,'%Y-%m'), energyConsumption.location.code, SUM(energyConsumption.kwh), SUM(energyConsumption.kva), SUM(energyConsumption.cost)) "
            + " FROM EnergyConsumption energyConsumption"
            + " WHERE energyConsumption.effectiveMonth BETWEEN :startDate AND :endDate"
            + " AND energyConsumption.location= :location"
            + " GROUP BY DATE_FORMAT(energyConsumption.effectiveMonth,'%Y-%m')")
    public List getMonthlyEnergyConsumptionByLocation(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("location") Location location);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.MonthlyLabourTurnover(DATE_FORMAT(labourTurnover.effectiveMonth,'%Y-%m'),labourTurnover.labourSource.code, SUM(labourTurnover.turnover), MAX(labourTurnover.target))"
            + " FROM LabourTurnover labourTurnover"
            + " WHERE labourTurnover.effectiveMonth BETWEEN :startDate AND :endDate"
            + " GROUP BY labourTurnover.labourSource, DATE_FORMAT(labourTurnover.effectiveMonth,'%Y-%m')")
    public List getMonthlyLabourTurnover(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.MonthlyAbsenteeism(DATE_FORMAT(absenteeism.effectiveMonth,'%Y-%m'),absenteeism.labourSource.code, SUM(absenteeism.absenteeism), MAX(absenteeism.target))"
            + " FROM Absenteeism absenteeism"
            + " WHERE absenteeism.effectiveMonth BETWEEN :startDate AND :endDate"
            + " GROUP BY absenteeism.labourSource, DATE_FORMAT(absenteeism.effectiveMonth,'%Y-%m')")
    public List getMonthlyAbsenteeism(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.MonthlySummary(DATE_FORMAT(salesValue.effectiveMonth,'%Y-%m'),SUM(salesValue.budget), MAX(salesValue.actual))"
            + " FROM SalesValue salesValue"
            + " WHERE salesValue.effectiveMonth BETWEEN :startDate AND :endDate"
            + " GROUP BY DATE_FORMAT(salesValue.effectiveMonth,'%Y-%m')")
    public List getMonthlySalesValue(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.MonthlySummary(DATE_FORMAT(salesWeight.effectiveMonth,'%Y-%m'),SUM(salesWeight.budget), MAX(salesWeight.actual))"
            + " FROM SalesWeight salesWeight"
            + " WHERE salesWeight.effectiveMonth BETWEEN :startDate AND :endDate"
            + " GROUP BY DATE_FORMAT(salesWeight.effectiveMonth,'%Y-%m')")
    public List getMonthlySalesWeight(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.MonthlySummary(DATE_FORMAT(labourCostPerKg.effectiveMonth,'%Y-%m'),SUM(labourCostPerKg.budget), MAX(labourCostPerKg.actual))"
            + " FROM LabourCostPerKg labourCostPerKg"
            + " WHERE labourCostPerKg.effectiveMonth BETWEEN :startDate AND :endDate"
            + " GROUP BY DATE_FORMAT(labourCostPerKg.effectiveMonth,'%Y-%m')")
    public List getMonthlyLabourCostPerKg(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.MonthlySummary(DATE_FORMAT(cumulativeSalesPerKg.effectiveMonth,'%Y-%m'),SUM(cumulativeSalesPerKg.budget), MAX(cumulativeSalesPerKg.actual))"
            + " FROM CumulativeSalesPerKg cumulativeSalesPerKg"
            + " WHERE cumulativeSalesPerKg.effectiveMonth BETWEEN :startDate AND :endDate"
            + " GROUP BY DATE_FORMAT(cumulativeSalesPerKg.effectiveMonth,'%Y-%m')")
    public List getMonthlyCumulativeSalesPerKg(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.MonthlySummary(DATE_FORMAT(productionOverheadCostPerKg.effectiveMonth,'%Y-%m'),SUM(productionOverheadCostPerKg.budget), MAX(productionOverheadCostPerKg.actual))"
            + " FROM ProductionOverheadCostPerKg productionOverheadCostPerKg"
            + " WHERE productionOverheadCostPerKg.effectiveMonth BETWEEN :startDate AND :endDate"
            + " GROUP BY DATE_FORMAT(productionOverheadCostPerKg.effectiveMonth,'%Y-%m')")
    public List getMonthlyProductionOverheadCostPerKg(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.MonthlySummary(DATE_FORMAT(salesPerKg.effectiveMonth,'%Y-%m'),SUM(salesPerKg.budget), MAX(salesPerKg.actual))"
            + " FROM SalesPerKg salesPerKg"
            + " WHERE salesPerKg.effectiveMonth BETWEEN :startDate AND :endDate"
            + " GROUP BY DATE_FORMAT(salesPerKg.effectiveMonth,'%Y-%m')")
    public List getMonthlySalesPerKg(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.MonthlySummary(DATE_FORMAT(consumableCostPerKg.effectiveMonth,'%Y-%m'),SUM(consumableCostPerKg.budget), MAX(consumableCostPerKg.actual))"
            + " FROM ConsumableCostPerKg consumableCostPerKg"
            + " WHERE consumableCostPerKg.effectiveMonth BETWEEN :startDate AND :endDate"
            + " GROUP BY DATE_FORMAT(consumableCostPerKg.effectiveMonth,'%Y-%m')")
    public List getMonthlyConsumableCostPerKg(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.MonthlySummary(DATE_FORMAT(materialCostPerKg.effectiveMonth,'%Y-%m'),SUM(materialCostPerKg.budget), MAX(materialCostPerKg.actual))"
            + " FROM MaterialCostPerKg materialCostPerKg"
            + " WHERE materialCostPerKg.effectiveMonth BETWEEN :startDate AND :endDate"
            + " GROUP BY DATE_FORMAT(materialCostPerKg.effectiveMonth,'%Y-%m')")
    public List getMonthlyMaterialCostPerKg(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.MonthlySummary(DATE_FORMAT(electricityCostPerKg.effectiveMonth,'%Y-%m'),SUM(electricityCostPerKg.budget), MAX(electricityCostPerKg.actual))"
            + " FROM ElectricityCostPerKg electricityCostPerKg"
            + " WHERE electricityCostPerKg.effectiveMonth BETWEEN :startDate AND :endDate"
            + " GROUP BY DATE_FORMAT(electricityCostPerKg.effectiveMonth,'%Y-%m')")
    public List getMonthlyElectricityCostPerKg(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.MonthlySummary(DATE_FORMAT(scrapCostPerKg.effectiveMonth,'%Y-%m'),SUM(scrapCostPerKg.budget), MAX(scrapCostPerKg.actual))"
            + " FROM ScrapCostPerKg scrapCostPerKg"
            + " WHERE scrapCostPerKg.effectiveMonth BETWEEN :startDate AND :endDate"
            + " GROUP BY DATE_FORMAT(scrapCostPerKg.effectiveMonth,'%Y-%m')")
    public List getMonthlyScrapCostPerKg(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    /* 
    @Query(value = "SELECT "
            + " DATE_FORMAT(labourTurnover.effectiveMonth,'%Y-%m') ,labourTurnover.labourSource.code, SUM(labourTurnover.turnover), labourTurnover.target"
            + " FROM LabourTurnover labourTurnover"
            + " WHERE labourTurnover.effectiveMonth BETWEEN :startDate AND :endDate"
            + " GROUP BY labourTurnover.labourSource, DATE_FORMAT(labourTurnover.effectiveMonth,'%Y-%m')")
    public List getMonthlyLabourTurnover(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
     */
}
