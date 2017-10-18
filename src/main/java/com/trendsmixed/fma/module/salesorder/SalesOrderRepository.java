package com.trendsmixed.fma.module.salesorder;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SalesOrderRepository extends PagingAndSortingRepository<SalesOrder, Integer> {

    public SalesOrder findByid(Integer id);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.salesOrderNumber, o.customerPoNumber)"
            + " FROM SalesOrder o")
    public List<Combo> getCombo();
}
