package com.trendsmixed.fma.module.operation;

import com.trendsmixed.fma.dao.OperationSummary;
import com.trendsmixed.fma.entity.Job;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.entity.Operation;
import com.trendsmixed.fma.entity.Section;
import com.trendsmixed.fma.entity.Shift;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class OperationService {

    @Autowired
    private OperationRepository repository;

    public Iterable<Operation> findAll() {
        return repository.findAll();
    }

    public Page<Operation> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Operation save(Operation operation) {
        return repository.save(operation);
    }

    public void save(List<Operation> operations) {
        repository.save(operations);
    }

    public Operation findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public List test(Date startDate, Date endDate) {
        return repository.test(startDate, endDate);
    }

    public Page<Operation> findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateAndProductionShift(Section section, Date date, Shift shift, Pageable pageable) {
        return repository.findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateAndProductionShift(section, date, shift, pageable);

    }

    public Page<Operation> findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateBetweenAndProductionShift(Section section, Date startDate, Date endDate, Shift shift, Pageable pageable) {
        return repository.findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateBetweenAndProductionShift(section, startDate, endDate, shift, pageable);
    }

    public Page<Operation> findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateBetween(Section section, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateBetween(section, startDate, endDate, pageable);
    }

    public Page<Operation> findByProductionProductionDateAndProductionShift(Date date, Shift shift, Pageable pageable) {
        return repository.findByProductionProductionDateAndProductionShift(date, shift, pageable);
    }

    public Page<Operation> findByProductionProductionDateBetweenAndProductionShift(Date startDate, Date endDate, Shift shift, Pageable pageable) {
        return repository.findByProductionProductionDateBetweenAndProductionShift(startDate, endDate, shift, pageable);
    }

    public Page<Operation> findByProductionProductionDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByProductionProductionDateBetween(startDate, endDate, pageable);
    }

    public Page<Operation> findByJob(Job job, Pageable pageable) {
        return repository.findByJob(job, pageable);
    }

    public List<OperationSummary> getSummaryByJob(int jobId) {
        return repository.getSummaryByJob(jobId);
    }
}
