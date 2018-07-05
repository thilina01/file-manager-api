package com.trendsmixed.fma.module.operation;

import com.trendsmixed.fma.dao.OperationSummary;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.production.Production;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.shift.Shift;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class OperationService {

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

    public Page<Operation> findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateBetweenAndProductionShift(Section section, Date startDate, Date endDate, Shift shift, Pageable pageable) {
        return repository.findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateBetweenAndProductionShift(section, startDate, endDate, shift, pageable);
    }

    public Page<Operation> findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateBetween(Section section, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateBetween(section, startDate, endDate, pageable);
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

    public List<Operation> findByProduction(Production production) {
        return repository.findByProduction(production);
    }
}
