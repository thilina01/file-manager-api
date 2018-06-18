package com.trendsmixed.fma.module.salesorder;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.salesordertype.SalesOrderType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SalesOrderRepository extends PagingAndSortingRepository<SalesOrder, Integer> {

        SalesOrder findByid(Integer id);

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, o.salesOrderNumber, o.customerPoNumber)"
                        + " FROM SalesOrder o")
        List<Combo> getCombo();

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, o.salesOrderNumber, o.customerPoNumber)"
                        + " FROM SalesOrder o" + " WHERE o.customer = :customer")
        List<Combo> getComboByCustomer(@Param("customer") Customer customer);

        // Iterable<SalesOrder> findByCustomerPoNumber(SalesOrder customerPoNumber);

        Page<SalesOrder> findByOrderDateBetween(Date startDate, Date endDate, Pageable pageable);

        Page<SalesOrder> findByOrderDateAndSalesOrderType(Date date, SalesOrderType salesOrderType, Pageable pageable);

        Page<SalesOrder> findByOrderDateBetweenAndSalesOrderType(Date startDate, Date endDate,
                        SalesOrderType salesOrderType, Pageable pageable);

        Page<SalesOrder> findByCustomerAndOrderDateBetween(Customer customer, Date startDate, Date endDate,
                        Pageable pageable);

        Page<SalesOrder> findByCustomerAndOrderDateAndSalesOrderType(Customer customer, Date date,
                        SalesOrderType salesOrderType, Pageable pageable);

        Page<SalesOrder> findByCustomerAndOrderDateBetweenAndSalesOrderType(Customer customer, Date startDate,
                        Date endDate, SalesOrderType salesOrderType, Pageable pageable);

        Page<SalesOrder> findByCustomer(Customer customer, Pageable pageable);

        Page<SalesOrder> findByCustomerPoNumber(String customerPoNumber, Pageable pageable);

}
