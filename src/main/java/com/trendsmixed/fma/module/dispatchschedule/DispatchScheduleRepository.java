package com.trendsmixed.fma.module.dispatchschedule;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Date;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.salesorder.SalesOrder;
import com.trendsmixed.fma.module.job.Job;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface DispatchScheduleRepository extends PagingAndSortingRepository<DispatchSchedule, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,o.job.jobNo,o.job.item.code)"
                        + " FROM DispatchSchedule o")
        List<Combo> getCombo();

        Iterable<DispatchSchedule> findBySalesOrderItemSalesOrder(SalesOrder salesOrder);

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,o.job.jobNo,o.job.item.code)"
                        + " FROM DispatchSchedule o" + " WHERE o.salesOrderItem.salesOrder.customer = :customer")
        List<Combo> getComboByCustomer(@Param("customer") Customer customer);

        Page<DispatchSchedule> findBySalesOrderItemSalesOrderOrderDateBetween(Date startDate, Date endDate,
                        Pageable pageable);

        Page<DispatchSchedule> findBySalesOrderItemSalesOrderOrderDateAndJob(Date date, Job job, Pageable pageable);

        Page<DispatchSchedule> findBySalesOrderItemSalesOrderOrderDateBetweenAndJob(Date startDate, Date endDate,
                        Job job, Pageable pageable);

        Page<DispatchSchedule> findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateBetween(
                        Customer customer, Date startDate, Date endDate, Pageable pageable);

        Page<DispatchSchedule> findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateAndJob(
                        Customer customer, Date date, Job job, Pageable pageable);

        Page<DispatchSchedule> findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateBetweenAndJob(
                        Customer customer, Date startDate, Date endDate, Job job, Pageable pageable);

        Page<DispatchSchedule> findBySalesOrderItemSalesOrderCustomer(Customer customer, Pageable pageable);

        Page<DispatchSchedule> findByJob(Job job, Pageable pageable);
}
