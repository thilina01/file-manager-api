package com.trendsmixed.fma.module.resourceutilization;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import lombok.AllArgsConstructor;
import java.util.Date;
import com.trendsmixed.fma.module.employee.Employee;
import com.trendsmixed.fma.module.shift.Shift;
import com.trendsmixed.fma.module.machine.Machine;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@AllArgsConstructor
@Service
public class ResourceUtilizationService {

    private ResourceUtilizationRepository repository;

    public Iterable<ResourceUtilization> findAll() {
        return repository.findAll();
    }

    public Page<ResourceUtilization> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public ResourceUtilization save(ResourceUtilization costCenter) {
        return repository.save(costCenter);
    }

    public void save(List<ResourceUtilization> costCenters) {
        repository.save(costCenters);
    }

    public ResourceUtilization findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Page<ResourceUtilization> findByProductionProductionDateBetweenAndProductionShift(Date startDate, Date endDate, Shift shift, Pageable pageable) {
        return repository.findByProductionProductionDateBetweenAndProductionShift(startDate, endDate, shift, pageable);
    }
    public Page<ResourceUtilization> findByProductionProductionDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByProductionProductionDateBetween(startDate, endDate, pageable);
    }
    public Page<ResourceUtilization> findByProductionProductionDateAndProductionShift(Date date, Shift shift, Pageable pageable) {
        return repository.findByProductionProductionDateAndProductionShift(date, shift, pageable);
    }
    public Page<ResourceUtilization> findByProductionProductionDateAndEmployee(Date date, Employee employee, Pageable pageable) {
        return repository.findByProductionProductionDateAndEmployee(date, employee, pageable);
    }
    public Page<ResourceUtilization> findByProductionProductionDateBetweenAndEmployee(Date startDate, Date endDate, Employee employee, Pageable pageable) {
        return repository.findByProductionProductionDateBetweenAndEmployee(startDate, endDate, employee, pageable);
    }
    public Page<ResourceUtilization> findByMachineAndProductionProductionDateBetween(Machine machine, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByMachineAndProductionProductionDateBetween(machine, startDate, endDate, pageable);
    }
    public Page<ResourceUtilization> findByMachineAndEmployeeAndProductionProductionDateAndProductionShift(Machine machine, Date date,Employee employee,Shift shift, Pageable pageable) {
        return repository.findByMachineAndEmployeeAndProductionProductionDateAndProductionShift(machine, date, employee,shift, pageable);
    }
    public Page<ResourceUtilization> findByMachineAndEmployeeAndProductionProductionDateBetweenAndProductionShift(Machine machine, Date startDate, Date endDate, Employee employee, Shift shift, Pageable pageable) {
        return repository.findByMachineAndEmployeeAndProductionProductionDateBetweenAndProductionShift(machine, startDate, endDate,employee,shift,pageable);
    }
}
