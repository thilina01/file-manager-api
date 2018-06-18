package com.trendsmixed.fma.module.employeecategory;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeCategoryRepository extends PagingAndSortingRepository<EmployeeCategory, Integer> {

    EmployeeCategory findByCode(String code);

    EmployeeCategory findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM EmployeeCategory o")
    List<Combo> getCombo();
}
