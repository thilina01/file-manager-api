package com.trendsmixed.fma.module.salesorderitem;

import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.customeritem.CustomerItem;
import com.trendsmixed.fma.module.salesorder.SalesOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface SalesOrderItemRepository extends PagingAndSortingRepository<SalesOrderItem, Integer> {

        Page<SalesOrderItem> findBySalesOrderOrderDateBetween(Date startDate, Date endDate, Pageable pageable);

        Page<SalesOrderItem> findBySalesOrderCustomerAndSalesOrderOrderDateBetween(Customer customer, Date startDate,
                        Date endDate, Pageable pageable);

        Page<SalesOrderItem> findByCustomerItemAndSalesOrderOrderDateBetween(CustomerItem customerItem, Date startDate,
                        Date endDate, Pageable pageable);

        Page<SalesOrderItem> findBySalesOrderAndSalesOrderOrderDateBetween(SalesOrder salesOrder, Date startDate,
                        Date endDate, Pageable pageable);

        Page<SalesOrderItem> findByCustomerItemAndSalesOrderOrderDateBetweenAndSalesOrderCustomer(
                        CustomerItem customerItem, Date startDate, Date endDate, Customer customer, Pageable pageable);

        Page<SalesOrderItem> findByCustomerItemAndSalesOrderOrderDateBetweenAndSalesOrder(CustomerItem customerItem,
                        Date startDate, Date endDate, SalesOrder salesOrder, Pageable pageable);

        Page<SalesOrderItem> findBySalesOrderAndSalesOrderOrderDateBetweenAndSalesOrderCustomer(SalesOrder salesOrder,
                        Date startDate, Date endDate, Customer customer, Pageable pageable);

        Page<SalesOrderItem> findBySalesOrderCustomerAndCustomerItemAndSalesOrderAndAndSalesOrderOrderDateBetween(
                        Customer customer, CustomerItem customerItem, SalesOrder salesOrder, Date startDate,
                        Date endDate, Pageable pageable);
}
