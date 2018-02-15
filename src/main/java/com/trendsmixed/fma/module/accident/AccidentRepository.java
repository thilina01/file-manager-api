package com.trendsmixed.fma.module.accident;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.employee.Employee;
import java.util.List;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccidentRepository extends PagingAndSortingRepository<Accident, Integer> {

    Accident findByCode(String code);

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, '')" + " FROM Accident o")
    List<Combo> getCombo();

    Page<Accident> findByAccidentDateBetween(Date startDate, Date endDate, Pageable pageable);

    Page<Accident> findByAccidentDateAndSection(Date date, Section section, Pageable pageable);

    Page<Accident> findBySectionAndAccidentDateBetween(Section section, Date startDate, Date endDate,
            Pageable pageable);

    Page<Accident> findByAccidentDateAndEmployee(Date date, Employee employee, Pageable pageable);

    Page<Accident> findByEmployeeAndAccidentDateBetween(Employee employee, Date startDate, Date endDate,
            Pageable pageable);

    Page<Accident> findByEmployee(Employee employee, Pageable pageable);
}
