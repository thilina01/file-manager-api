package com.trendsmixed.fma.module.operation;

import com.trendsmixed.fma.dao.ScheduleAdherence;
import com.trendsmixed.fma.entity.Operation;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation, Integer> {

    //@Query(value = "select teamMenu.menu from TeamMenu teamMenu where teamMenu.team= :team And teamMenu.menu.menu IS NULL ")
	/*@Query(value = "SELECT operation.production.controlPoint.workCenter.costCenter.section.code as section,"
            + " SUM(operation.actualQuantity)  as actualTotal," 
            + " SUM(operation.plannedQuantity) as plannedTotal,"
            + " (SUM(operation.actualQuantity)/SUM(operation.plannedQuantity))*100 as value"
            + " FROM Operation operation"
            + " WHERE operation.production.productionDate BETWEEN '2017-02-01' AND '2017-02-28'"
            + " GROUP BY operation.production.controlPoint.workCenter.costCenter.section")
	*/
	@Query(value = "SELECT "
			+ " new com.trendsmixed.fma.dao.ScheduleAdherence(operation.production.controlPoint.workCenter.costCenter.section.code, SUM(operation.actualQuantity), SUM(operation.plannedQuantity), (SUM(operation.actualQuantity)/SUM(operation.plannedQuantity))*100) "
            + " FROM Operation operation"
            + " WHERE operation.production.productionDate BETWEEN :startDate AND :endDate"
            + " GROUP BY operation.production.controlPoint.workCenter.costCenter.section")
    public List test(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
//com.trendsmixed.fma.dao.ScheduleAdherence