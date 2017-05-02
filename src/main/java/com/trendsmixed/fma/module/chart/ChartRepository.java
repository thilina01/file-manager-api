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
