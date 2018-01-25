package com.trendsmixed.fma.module.operationprogress;

import java.util.List;
import java.util.Date;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.job.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface OperationProgressRepository extends PagingAndSortingRepository<OperationProgress, Integer> {

        Page<OperationProgress> findByOperationProductionProductionDateBetween(Date startDate, Date endDate,
                        Pageable pageable);

        Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateBetween(
                        Section section, Date startDate, Date endDate, Pageable pageable);

        Page<OperationProgress> findByOperationProductionProductionDateAndOperationProductionControlPoint(Date date,
                        ControlPoint controlPoint, Pageable pageable);

        Page<OperationProgress> findByOperationProductionProductionDateBetweenAndOperationProductionControlPoint(
                        Date startDate, Date endDate, ControlPoint controlPoint, Pageable pageable);

        Page<OperationProgress> findByOperationProductionProductionDateBetweenAndOperationJob(Date startDate,
                        Date endDate, Job job, Pageable pageable);

        Page<OperationProgress> findByOperationProductionProductionDateAndOperationJob(Date date, Job job,
                        Pageable pageable);

        Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationJobAndOperationProductionProductionDateAndOperationProductionControlPoint(
                        Section section, Date date, ControlPoint controlPoint, Job job, Pageable pageable);

        Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationJobAndOperationProductionProductionDateBetweenAndOperationProductionControlPoint(
                        Section section, Date startDate, Date endDate, ControlPoint controlPoint, Pageable pageable,
                        Job job);

}
