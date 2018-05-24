package com.trendsmixed.fma.module.salesorderitem;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Date;

import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.salesorder.SalesOrder;

public interface SalesOrderItemRepository extends PagingAndSortingRepository<SalesOrderItem, Integer> {

    Page<SalesOrderItem> findBySalesOrderOrderDateBetween(Date startDate, Date endDate, Pageable pageable);

    Page<SalesOrderItem> findBySalesOrderCustomerAndSalesOrderOrderDateBetween(Customer customer, Date startDate,
            Date endDate, Pageable pageable);

    Page<SalesOrderItem> findByCustomerItemItemAndSalesOrderOrderDateBetween(Item item, Date startDate, Date endDate,
            Pageable pageable);

    Page<SalesOrderItem> findBySalesOrderAndSalesOrderOrderDateBetween(SalesOrder salesOrder, Date startDate,
            Date endDate, Pageable pageable);

    Page<SalesOrderItem> findByCustomerItemItemAndSalesOrderOrderDateBetweenAndSalesOrderCustomer(Item item,
            Date startDate, Date endDate, Customer customer, Pageable pageable);

    Page<SalesOrderItem> findByCustomerItemItemAndSalesOrderOrderDateBetweenAndSalesOrder(Item item, Date startDate,
            Date endDate, SalesOrder salesOrder, Pageable pageable);

    Page<SalesOrderItem> findBySalesOrderAndSalesOrderOrderDateBetweenAndSalesOrderCustomer(SalesOrder salesOrder,
            Date startDate, Date endDate, Customer customer, Pageable pageable);

    Page<SalesOrderItem> findBySalesOrderCustomerAndCustomerItemItemAndSalesOrderAndAndSalesOrderOrderDateBetween( Customer customer,Item item,SalesOrder salesOrder,
    Date startDate, Date endDate, Pageable pageable);
}
