package com.trendsmixed.fma.module.salesordertype;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SalesOrderTypeRepository extends PagingAndSortingRepository<SalesOrderType, Integer> {

    public SalesOrderType findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM SalesOrderType o")
    public List<Combo> getCombo();
}
