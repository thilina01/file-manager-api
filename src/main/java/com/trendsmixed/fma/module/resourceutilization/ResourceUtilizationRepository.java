package com.trendsmixed.fma.module.resourceutilization;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import com.trendsmixed.fma.module.shift.Shift;
import com.trendsmixed.fma.module.employee.Employee;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.trendsmixed.fma.module.machine.Machine;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ResourceUtilizationRepository extends PagingAndSortingRepository<ResourceUtilization, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,'', '')" + " FROM ResourceUtilization o")
        List<Combo> getCombo();

        Page<ResourceUtilization> findByProductionProductionDateBetween(Date startDate, Date endDate,
                        Pageable pageable);

        Page<ResourceUtilization> findByProductionProductionDateBetweenAndProductionShift(Date startDate, Date endDate,
                        Shift shift, Pageable pageable);

        Page<ResourceUtilization> findByProductionProductionDateAndProductionShift(Date date, Shift shift,
                        Pageable pageable);

        Page<ResourceUtilization> findByProductionProductionDateBetweenAndEmployee(Date startDate, Date endDate,
                        Employee employee, Pageable pageable);

        Page<ResourceUtilization> findByProductionProductionDateAndEmployee(Date date, Employee employee,
                        Pageable pageable);

        Page<ResourceUtilization> findByMachineAndProductionProductionDateBetween(Machine machine, Date startDate,
                        Date endDate, Pageable pageable);

        Page<ResourceUtilization> findByMachineAndEmployeeAndProductionProductionDateAndProductionShift(Machine machine,
                        Date date, Employee employee, Shift shift, Pageable pageable);

        Page<ResourceUtilization> findByMachineAndEmployeeAndProductionProductionDateBetweenAndProductionShift(
                        Machine machine, Date startDate, Date endDate, Employee employee, Shift shift,
                        Pageable pageable);

}
