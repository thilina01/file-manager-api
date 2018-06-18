package com.trendsmixed.fma.module.employee;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

    Employee findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.callingName)"
            + " FROM Employee o")
    List<Combo> getCombo();

    Employee findOneByCustomerListId(int id);

}
