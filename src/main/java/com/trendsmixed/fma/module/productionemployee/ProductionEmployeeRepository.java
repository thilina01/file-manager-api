package com.trendsmixed.fma.module.productionemployee;

import com.trendsmixed.fma.module.employee.Employee;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.shift.Shift;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductionEmployeeRepository extends PagingAndSortingRepository<ProductionEmployee, Integer> {

    Page<ProductionEmployee> findByProductionProductionDateBetween(Date startDate, Date endDate, Pageable pageable);

    Page<ProductionEmployee> findByProductionProductionDateBetweenAndProductionShift(Date startDate, Date endDate, Shift shift, Pageable pageable);

    Page<ProductionEmployee> findByProductionProductionDateAndProductionShift(Date date, Shift shift, Pageable pageable);

    Page<ProductionEmployee> findByProductionControlPointWorkCenterCostCenterSectionAndProductionProductionDateBetween(Section section, Date startDate, Date endDate, Pageable pageable);

    Page<ProductionEmployee> findByProductionProductionDateBetweenAndEmployee(Date startDate, Date endDate, Employee employee, Pageable pageable);

    Page<ProductionEmployee> findByProductionProductionDateAndEmployee(Date date, Employee employee, Pageable pageable);

    Page<ProductionEmployee> findByProductionControlPointWorkCenterCostCenterSectionAndEmployeeAndProductionProductionDateAndProductionShift(Section section, Date date, Shift shift, Employee employee, Pageable pageable);

    Page<ProductionEmployee> findByProductionControlPointWorkCenterCostCenterSectionAndEmployeeAndProductionProductionDateBetweenAndProductionShift(Section section, Date startDate, Date endDate, Shift shift, Pageable pageable, Employee employee);

}
