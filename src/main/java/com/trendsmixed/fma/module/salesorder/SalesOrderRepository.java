package com.trendsmixed.fma.module.salesorder;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import java.util.Date;
import com.trendsmixed.fma.module.salesordertype.SalesOrderType;
import com.trendsmixed.fma.module.customer.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SalesOrderRepository extends PagingAndSortingRepository<SalesOrder, Integer> {

        SalesOrder findByid(Integer id);

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, o.salesOrderNumber, o.customerPoNumber)"
                        + " FROM SalesOrder o")
        List<Combo> getCombo();

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

}
