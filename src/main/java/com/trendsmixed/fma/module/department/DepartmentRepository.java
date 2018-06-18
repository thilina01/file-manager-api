package com.trendsmixed.fma.module.department;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DepartmentRepository extends PagingAndSortingRepository<Department, Integer> {

    Department findByCode(String code);

    Department findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Department o")
    List<Combo> getCombo();
}
