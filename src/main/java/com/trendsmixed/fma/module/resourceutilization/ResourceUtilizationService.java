package com.trendsmixed.fma.module.resourceutilization;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.employee.Employee;
import com.trendsmixed.fma.module.machine.Machine;
import com.trendsmixed.fma.module.shift.Shift;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    public ResourceUtilization save(ResourceUtilization resourceUtilization) {
        return repository.save(resourceUtilization);
    }

    public void save(List<ResourceUtilization> resourceUtilizations) {
        repository.save(resourceUtilizations);
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

    public Page<ResourceUtilization> findByProductionProductionDateBetweenAndEmployee(Date startDate, Date endDate, Employee employee, Pageable pageable) {
        return repository.findByProductionProductionDateBetweenAndEmployee(startDate, endDate, employee, pageable);
    }

    public Page<ResourceUtilization> findByMachineAndProductionProductionDateBetween(Machine machine, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByMachineAndProductionProductionDateBetween(machine, startDate, endDate, pageable);
    }

    public Page<ResourceUtilization> findByMachineAndEmployeeAndProductionProductionDateBetweenAndProductionShift(Machine machine,Employee employee, Date startDate, Date endDate,  Shift shift, Pageable pageable) {
        return repository.findByMachineAndEmployeeAndProductionProductionDateBetweenAndProductionShift(machine,employee, startDate, endDate,shift,pageable);
    }

    public Page<ResourceUtilization> findByMachineAndProductionProductionDateBetweenAndProductionShift(Machine machine, Date startDate, Date endDate, Shift shift, Pageable pageable) {
        return repository.findByMachineAndProductionProductionDateBetweenAndProductionShift(machine, startDate, endDate, shift, pageable);
    }

    public Page<ResourceUtilization> findByMachineAndProductionProductionDateBetweenAndEmployee(Machine machine, Date startDate, Date endDate, Employee employee, Pageable pageable) {
       return repository.findByMachineAndProductionProductionDateBetweenAndEmployee(machine, startDate, endDate, employee, pageable);
    }

    public Page<ResourceUtilization> findByEmployeeAndProductionProductionDateBetweenAndProductionShift(Employee employee, Date startDate, Date endDate, Shift shift, Pageable pageable) {
       return repository.findByEmployeeAndProductionProductionDateBetweenAndProductionShift(employee, startDate, endDate, shift, pageable);
    }

}
