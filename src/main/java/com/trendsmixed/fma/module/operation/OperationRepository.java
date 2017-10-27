package com.trendsmixed.fma.module.operation;

import com.trendsmixed.fma.dao.OperationSummary;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.production.Production;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.shift.Shift;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends PagingAndSortingRepository<Operation, Integer> {

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.ScheduleAdherence(operation.production.controlPoint.workCenter.costCenter.section.code, SUM(operation.actualQuantity), SUM(operation.plannedQuantity), (SUM(operation.actualQuantity)/SUM(operation.plannedQuantity))*100) "
            + " FROM Operation operation"
            + " WHERE operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " GROUP BY operation.production.controlPoint.workCenter.costCenter.section")
    List test(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    Page<Operation> findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateAndProductionShift(Section section, Date date, Shift shift, Pageable pageable);

    Page<Operation> findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateBetweenAndProductionShift(Section section, Date startDate, Date endDate, Shift shift, Pageable pageable);

    Page<Operation> findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateBetween(Section section, Date startDate, Date endDate, Pageable pageable);

    Page<Operation> findByProductionProductionDateAndProductionShift(Date date, Shift shift, Pageable pageable);

    Page<Operation> findByProductionProductionDateBetweenAndProductionShift(Date startDate, Date endDate, Shift shift, Pageable pageable);

    Page<Operation> findByProductionProductionDateBetween(Date startDate, Date endDate, Pageable pageable);

    Page<Operation> findByJob(Job job, Pageable pageable);

    @Query(value = "SELECT "
            + " new com.trendsmixed.fma.dao.OperationSummary(operation.productType,operation.operationType,SUM(operation.actualQuantity)) "
            + " FROM Operation operation"
            + " WHERE operation.job.id = :jobId AND operation.actualQuantity IS NOT NULL"
            + " GROUP BY operation.productType, operation.operationType ")
    List<OperationSummary> getSummaryByJob(@Param("jobId") int jobId);

    List<Operation> findByProduction(Production production);

}
