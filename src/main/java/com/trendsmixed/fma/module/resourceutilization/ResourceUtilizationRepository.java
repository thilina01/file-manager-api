package com.trendsmixed.fma.module.resourceutilization;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.employee.Employee;
import com.trendsmixed.fma.module.machine.Machine;
import com.trendsmixed.fma.module.shift.Shift;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface ResourceUtilizationRepository extends PagingAndSortingRepository<ResourceUtilization, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,'', '')" + " FROM ResourceUtilization o")
        List<Combo> getCombo();

        Page<ResourceUtilization> findByProductionProductionDateBetween(Date startDate, Date endDate,
                        Pageable pageable);

        Page<ResourceUtilization> findByProductionProductionDateBetweenAndProductionShift(Date startDate, Date endDate,
                        Shift shift, Pageable pageable);

        Page<ResourceUtilization> findByProductionProductionDateBetweenAndEmployee(Date startDate, Date endDate,
                        Employee employee, Pageable pageable);

        Page<ResourceUtilization> findByMachineAndProductionProductionDateBetween(Machine machine, Date startDate,
                        Date endDate, Pageable pageable);

        Page<ResourceUtilization> findByMachineAndEmployeeAndProductionProductionDateBetweenAndProductionShift(
                        Machine machine, Employee employee, Date startDate, Date endDate, Shift shift,
                        Pageable pageable);

        Page<ResourceUtilization> findByMachineAndProductionProductionDateBetweenAndProductionShift(Machine machine,
                        Date startDate, Date endDate, Shift shift, Pageable pageable);

        Page<ResourceUtilization> findByMachineAndProductionProductionDateBetweenAndEmployee(Machine machine,
                        Date startDate, Date endDate, Employee employee, Pageable pageable);

        Page<ResourceUtilization> findByEmployeeAndProductionProductionDateBetweenAndProductionShift(Employee employee,
                        Date startDate, Date endDate, Shift shift, Pageable pageable);

}
