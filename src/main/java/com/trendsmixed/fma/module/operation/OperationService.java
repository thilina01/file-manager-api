package com.trendsmixed.fma.module.operation;

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

}
