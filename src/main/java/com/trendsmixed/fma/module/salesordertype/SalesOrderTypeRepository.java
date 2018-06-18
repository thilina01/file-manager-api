package com.trendsmixed.fma.module.salesordertype;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SalesOrderTypeRepository extends PagingAndSortingRepository<SalesOrderType, Integer> {

    SalesOrderType findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM SalesOrderType o")
    List<Combo> getCombo();
}
