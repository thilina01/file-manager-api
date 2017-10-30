package com.trendsmixed.fma.module.productionemployee;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface ProductionEmployeeRepository extends PagingAndSortingRepository<ProductionEmployee, Integer> {


    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, '','')"
            + " FROM ProductionEmployee o")
    List<Combo> getCombo();
}
