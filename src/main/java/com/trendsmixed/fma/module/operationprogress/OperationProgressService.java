package com.trendsmixed.fma.module.operationprogress;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import java.util.Date;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.job.Job;
import org.springframework.data.domain.Page;

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
    public Page<OperationProgress> findByOperationProductionProductionDateAndOperationProductionControlPoint(Date date, ControlPoint controlPoint, Pageable pageable) {
        return repository.findByOperationProductionProductionDateAndOperationProductionControlPoint(date, controlPoint, pageable);
    }
    public Page<OperationProgress> findByOperationProductionProductionDateBetweenAndOperationProductionControlPoint(Date startDate, Date endDate, ControlPoint controlPoint, Pageable pageable) {
        return repository.findByOperationProductionProductionDateBetweenAndOperationProductionControlPoint(startDate, endDate, controlPoint, pageable);
    }
    public Page<OperationProgress> findByOperationProductionProductionDateBetweenAndOperationJob(Date startDate, Date endDate, Job job, Pageable pageable) {
        return repository.findByOperationProductionProductionDateBetweenAndOperationJob(startDate, endDate, job, pageable);
    }
    public Page<OperationProgress> findByOperationProductionProductionDateAndOperationJob(Date date, Job job, Pageable pageable) {
        return repository.findByOperationProductionProductionDateAndOperationJob(date, job, pageable);
    }
    public Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationJobAndOperationProductionProductionDateBetweenAndOperationProductionControlPoint(Section section,Job job, Date startDate, Date endDate,  ControlPoint controlPoint, Pageable pageable) {
        return repository.findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationJobAndOperationProductionProductionDateBetweenAndOperationProductionControlPoint(section, job, startDate, endDate, controlPoint, pageable);
    }
    public Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationJobAndOperationProductionProductionDateAndOperationProductionControlPoint(Section section, Date date, ControlPoint controlPoint, Job job, Pageable pageable) {
        return repository.findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationJobAndOperationProductionProductionDateAndOperationProductionControlPoint(section, date, controlPoint, job, pageable);
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
    public Page<OperationProgress> findByOperationProductionControlPointAndOperationProductionProductionDateAndOperationJob(ControlPoint controlPoint, Date date, Job job, Pageable pageable) {
        return repository.findByOperationProductionControlPointAndOperationProductionProductionDateAndOperationJob(controlPoint, date, job, pageable);
    }
    public Page<OperationProgress> findByOperationProductionControlPointAndOperationProductionProductionDateBetweenAndOperationJob(ControlPoint controlPoint, Date startDate, Date endDate, Job job, Pageable pageable) {
        return repository.findByOperationProductionControlPointAndOperationProductionProductionDateBetweenAndOperationJob(controlPoint, startDate, endDate, job, pageable);
    } 
    public Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateAndOperationJob(Section section, Date date, Job job, Pageable pageable) {
        return repository.findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateAndOperationJob(section, date, job, pageable);
    }
    public Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateBetweenAndOperationJob(Section section, Date startDate, Date endDate, Job job, Pageable pageable) {
        return repository.findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateBetweenAndOperationJob(section, startDate, endDate, job, pageable);
    }
    public Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateAndOperationProductionControlPoint(Section section, Date date, ControlPoint controlPoint, Pageable pageable) {
        return repository.findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateAndOperationProductionControlPoint(section, date, controlPoint, pageable);
    }
    public Page<OperationProgress> findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateBetweenAndOperationProductionControlPoint(Section section, Date startDate, Date endDate, ControlPoint controlPoint, Pageable pageable) {
        return repository.findByOperationProductionControlPointWorkCenterCostCenterSectionAndOperationProductionProductionDateBetweenAndOperationProductionControlPoint(section, startDate, endDate, controlPoint, pageable);
    }
}
