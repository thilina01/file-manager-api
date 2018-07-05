package com.trendsmixed.fma.module.operationprogress;

import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.section.Section;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class OperationProgressService {

    private OperationProgressRepository repository;

    public Iterable<OperationProgress> findAll() {
        return repository.findAll();
    }

    public Page<OperationProgress> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public OperationProgress save(OperationProgress operationProgress) {
        return repository.save(operationProgress);
    }

    public void save(List<OperationProgress> operationProgresses) {
        repository.save(operationProgresses);
    }

    public OperationProgress findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Page<OperationProgress> findByOperationProductionProductionDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByOperationProductionProductionDateBetween(startDate, endDate, pageable);
    }

    public Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateBetween(Section section, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateBetween(section, startDate, endDate, pageable);
    }

    public Page<OperationProgress> findByOperationProductionProductionDateBetweenAndOperationProductionControlPoint(Date startDate, Date endDate, ControlPoint controlPoint, Pageable pageable) {
        return repository.findByOperationProductionProductionDateBetweenAndOperationProductionControlPoint(startDate, endDate, controlPoint, pageable);
    }

    public Page<OperationProgress> findByOperationProductionProductionDateBetweenAndOperationJob(Date startDate, Date endDate, Job job, Pageable pageable) {
        return repository.findByOperationProductionProductionDateBetweenAndOperationJob(startDate, endDate, job, pageable);
    }

    public Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationJobAndOperationProductionProductionDateBetweenAndOperationProductionControlPoint(Section section,Job job, Date startDate, Date endDate,  ControlPoint controlPoint, Pageable pageable) {
        return repository.findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationJobAndOperationProductionProductionDateBetweenAndOperationProductionControlPoint(section, job, startDate, endDate, controlPoint, pageable);
    }

    Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSection(Section section, Pageable pageable) {
        return repository.findByOperationProductionControlPointWorkCenterCostCenterSection(section, pageable);
    }

    Page<OperationProgress> findByOperationJob(Job job, Pageable pageable) {
        return repository.findByOperationJob(job, pageable);
    }

    Page<OperationProgress> findByOperationProductionControlPoint(ControlPoint controlPoint, Pageable pageable) {
        return repository.findByOperationProductionControlPoint(controlPoint, pageable);
    }

    public Page<OperationProgress> findByOperationProductionControlPointAndOperationProductionProductionDateBetweenAndOperationJob(ControlPoint controlPoint, Date startDate, Date endDate, Job job, Pageable pageable) {
        return repository.findByOperationProductionControlPointAndOperationProductionProductionDateBetweenAndOperationJob(controlPoint, startDate, endDate, job, pageable);
    }

    public Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateBetweenAndOperationJob(Section section, Date startDate, Date endDate, Job job, Pageable pageable) {
        return repository.findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateBetweenAndOperationJob(section, startDate, endDate, job, pageable);
    }
    
    public Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateBetweenAndOperationProductionControlPoint(Section section, Date startDate, Date endDate, ControlPoint controlPoint, Pageable pageable) {
        return repository.findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateBetweenAndOperationProductionControlPoint(section, startDate, endDate, controlPoint, pageable);
    }
}
