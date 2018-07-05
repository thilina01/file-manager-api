package com.trendsmixed.fma.module.operationprogress;

import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.section.Section;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface OperationProgressRepository extends PagingAndSortingRepository<OperationProgress, Integer> {

        Page<OperationProgress> findByOperationProductionProductionDateBetween(Date startDate, Date endDate,
                        Pageable pageable);

        Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateBetween(
                        Section section, Date startDate, Date endDate, Pageable pageable);

        Page<OperationProgress> findByOperationProductionProductionDateBetweenAndOperationProductionControlPoint(
                        Date startDate, Date endDate, ControlPoint controlPoint, Pageable pageable);

        Page<OperationProgress> findByOperationProductionProductionDateBetweenAndOperationJob(Date startDate,
                        Date endDate, Job job, Pageable pageable);

        Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationJobAndOperationProductionProductionDateBetweenAndOperationProductionControlPoint(
                        Section section, Job job, Date startDate, Date endDate, ControlPoint controlPoint,
                        Pageable pageable);

        Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSection(Section section,
                        Pageable pageable);

        Page<OperationProgress> findByOperationJob(Job job, Pageable pageable);

        Page<OperationProgress> findByOperationProductionControlPoint(ControlPoint controlPoint, Pageable pageable);

        Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateBetweenAndOperationJob(
                        Section section, Date startDate, Date endDate, Job job, Pageable pageable);

        Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateBetweenAndOperationProductionControlPoint(
                        Section section, Date startDate, Date endDate, ControlPoint controlPoint, Pageable pageable);

        Page<OperationProgress> findByOperationProductionControlPointAndOperationProductionProductionDateBetweenAndOperationJob(
                        ControlPoint controlPoint, Date startDate, Date endDate, Job job, Pageable pageable);

}
