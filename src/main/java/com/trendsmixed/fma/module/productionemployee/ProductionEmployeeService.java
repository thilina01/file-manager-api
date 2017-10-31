package com.trendsmixed.fma.module.productionemployee;

import com.trendsmixed.fma.module.employee.Employee;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.shift.Shift;
import java.util.Date;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@Service
public class ProductionEmployeeService {

    private ProductionEmployeeRepository repository;

    public Iterable<ProductionEmployee> findAll() {
        return repository.findAll();
    }

    public Page<ProductionEmployee> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public ProductionEmployee save(ProductionEmployee productionEmployee) {
        return repository.save(productionEmployee);
    }

    public void save(List<ProductionEmployee> items) {
        repository.save(items);
    }

    public ProductionEmployee findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Page<ProductionEmployee> findByProductionProductionDateBetweenAndProductionShift(Date startDate, Date endDate, Shift shift, Pageable pageable) {
        return repository.findByProductionProductionDateBetweenAndProductionShift(startDate, endDate, shift, pageable);
    }

    public Page<ProductionEmployee> findByProductionProductionDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByProductionProductionDateBetween(startDate, endDate, pageable);
    }

    public Page<ProductionEmployee> findByProductionProductionDateAndProductionShift(Date date, Shift shift, Pageable pageable) {
        return repository.findByProductionProductionDateAndProductionShift(date, shift, pageable);
    }

    public Page<ProductionEmployee> findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateBetween(Section section, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateBetween(section, startDate, endDate, pageable);
    }

    public Page<ProductionEmployee> findByProductionProductionDateAndEmployee(Date date, Employee employee, Pageable pageable) {
        return repository.findByProductionProductionDateAndEmployee(date, employee, pageable);
    }

    public Page<ProductionEmployee> findByProductionProductionDateBetweenAndEmployee(Date startDate, Date endDate, Employee employee, Pageable pageable) {
        return repository.findByProductionProductionDateBetweenAndEmployee(startDate, endDate, employee, pageable);
    }

    public Page<ProductionEmployee> findByProductionControlPointWorkCenterCostCenterSectionAndEmployeeAndProductionProductionDateBetweenAndProductionShift(Section section, Date startDate, Date endDate, Employee employee, Shift shift, Pageable pageable) {
        return repository.findByProductionControlPointWorkCenterCostCenterSectionAndEmployeeAndProductionProductionDateBetweenAndProductionShift(section, startDate, endDate, shift, pageable, employee);
    }

    public Page<ProductionEmployee> findByProductionControlPointWorkCenterCostCenterSectionAndEmployeeAndProductionProductionDateAndProductionShift(Section section, Date date, Shift shift, Employee employee, Pageable pageable) {
        return repository.findByProductionControlPointWorkCenterCostCenterSectionAndEmployeeAndProductionProductionDateAndProductionShift(section, date, shift, employee, pageable);

    }

}
