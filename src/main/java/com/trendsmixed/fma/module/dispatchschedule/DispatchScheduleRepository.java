package com.trendsmixed.fma.module.dispatchschedule;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.salesorder.SalesOrder;
import com.trendsmixed.fma.module.salesordertype.SalesOrderType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface DispatchScheduleRepository extends PagingAndSortingRepository<DispatchSchedule, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,o.job.jobNo,o.job.item.code)"
                        + " FROM DispatchSchedule o")
        List<Combo> getCombo();

        Iterable<DispatchSchedule> findBySalesOrderItemSalesOrder(SalesOrder salesOrder);

        Iterable<DispatchSchedule> findBySalesOrderItemSalesOrderCustomer(Customer customer);

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

        Page<DispatchSchedule> findByJobItemAndSalesOrderItemSalesOrderOrderDateBetween(Item item, Date startDate,
                        Date endDate, Pageable pageable);

        Page<DispatchSchedule> findBySalesOrderItemSalesOrderSalesOrderTypeAndSalesOrderItemSalesOrderOrderDateBetween(
                        SalesOrderType salesOrderType, Date startDate, Date endDate, Pageable pageable);

        Page<DispatchSchedule> findByJobItemAndSalesOrderItemSalesOrderOrderDateBetweenAndJob(Item item, Date startDate,
                        Date endDate, Job job, Pageable pageable);

        Page<DispatchSchedule> findByJobItemAndSalesOrderItemSalesOrderOrderDateBetweenAndSalesOrderItemSalesOrderSalesOrderType(
                        Item item, Date startDate, Date endDate, SalesOrderType salesOrderType, Pageable pageable);

        Page<DispatchSchedule> findByJobItemAndSalesOrderItemSalesOrderOrderDateBetweenAndSalesOrderItemSalesOrderCustomer(
                        Item item, Date startDate, Date endDate, Customer customer, Pageable pageable);

        Page<DispatchSchedule> findBySalesOrderItemSalesOrderSalesOrderTypeAndSalesOrderItemSalesOrderOrderDateBetweenAndJob(
                        SalesOrderType salesOrderType, Date startDate, Date endDate, Job job, Pageable pageable);

        Page<DispatchSchedule> findBySalesOrderItemSalesOrderSalesOrderTypeAndSalesOrderItemSalesOrderOrderDateBetweenAndSalesOrderItemSalesOrderCustomer(
                        SalesOrderType salesOrderType, Date startDate, Date endDate, Customer Customer,
                        Pageable pageable);

        Page<DispatchSchedule> findBySalesOrderItemSalesOrderOrderDateBetweenAndSalesOrderItemSalesOrder(Date startDate,
                        Date endDate, SalesOrder salesOrder, Pageable pageable);

        Page<DispatchSchedule> findBySalesOrderItemSalesOrderOrderDateBetweenAndJobAndSalesOrderItemSalesOrder(
                        Date startDate, Date endDate, Job job, SalesOrder salesOrder, Pageable pageable);

        Page<DispatchSchedule> findBySalesOrderItemSalesOrderOrderDateBetweenAndSalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrder(
                        Date startDate, Date endDate, Customer customer, SalesOrder salesOrder, Pageable pageable);

}
