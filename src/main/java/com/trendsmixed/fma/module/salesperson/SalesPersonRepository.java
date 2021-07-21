package com.trendsmixed.fma.module.salesperson;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SalesPersonRepository extends PagingAndSortingRepository<SalesPerson, Integer> {

    SalesPerson findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM SalesPerson o")
    List<Combo> getCombo();
}
