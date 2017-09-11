package com.trendsmixed.fma.module.dispatchschedule;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.salesorder.SalesOrder;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DispatchScheduleRepository extends PagingAndSortingRepository<DispatchSchedule, Integer> {

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id,o.job.jobNo,o.job.item.code)"
            + " FROM DispatchSchedule o")
    public List<Combo> getCombo();

    public Iterable<DispatchSchedule> findBySalesOrderItemSalesOrder(SalesOrder salesOrder);

}
