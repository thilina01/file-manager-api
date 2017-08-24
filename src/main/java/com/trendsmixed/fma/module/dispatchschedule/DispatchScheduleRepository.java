package com.trendsmixed.fma.module.dispatchschedule;

import com.trendsmixed.fma.module.salesorder.SalesOrder;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DispatchScheduleRepository extends PagingAndSortingRepository<DispatchSchedule, Integer> {

    public Iterable<DispatchSchedule> findBySalesOrderItemSalesOrder(SalesOrder salesOrder);
}
