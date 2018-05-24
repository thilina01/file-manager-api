package com.trendsmixed.fma.module.salesorder;

import com.trendsmixed.fma.module.salesordertype.SalesOrderType;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import lombok.AllArgsConstructor;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SalesOrderService {

    private SalesOrderRepository repository;

    public Iterable<SalesOrder> findAll() {
        return repository.findAll();
    }

    public Page<SalesOrder> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SalesOrder save(SalesOrder SalesOrder) {
        return repository.save(SalesOrder);
    }

    public void save(List<SalesOrder> SalesOrder) {
        repository.save(SalesOrder);
    }

    public SalesOrder findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public SalesOrder findByid(Integer id) {
        return repository.findByid(id);
    }
    public Page<SalesOrder> findByOrderDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByOrderDateBetween(startDate, endDate, pageable);

    }
    public Page<SalesOrder> findByOrderDateAndSalesOrderType(Date date, SalesOrderType salesOrderType, Pageable pageable) {
        return repository.findByOrderDateAndSalesOrderType(date, salesOrderType, pageable);
    }

    public Page<SalesOrder> findByOrderDateBetweenAndSalesOrderType(Date startDate, Date endDate, SalesOrderType salesOrderType, Pageable pageable) {
        return repository.findByOrderDateBetweenAndSalesOrderType(startDate, endDate, salesOrderType, pageable);
    }

    public Page<SalesOrder> findByCustomerAndOrderDateBetween(Customer customer, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByCustomerAndOrderDateBetween(customer, startDate, endDate, pageable);
    }
   
    public Page<SalesOrder> findByCustomerAndOrderDateAndSalesOrderType(Customer customer, Date date, SalesOrderType salesOrderType, Pageable pageable) {
        return repository.findByCustomerAndOrderDateAndSalesOrderType(customer, date, salesOrderType, pageable);

    }

    public Page<SalesOrder> findByCustomerAndOrderDateBetweenAndSalesOrderType(Customer customer, Date startDate, Date endDate, SalesOrderType salesOrderType, Pageable pageable) {
        return repository.findByCustomerAndOrderDateBetweenAndSalesOrderType(customer, startDate, endDate, salesOrderType, pageable);
    }

    Page<SalesOrder> findByCustomer(Customer customer, Pageable pageable) {
        return repository.findByCustomer(customer, pageable);
    }

    public List<Combo> getComboByCustomer(Customer customer) {
        return repository.getComboByCustomer(customer);
    }

}
