package com.trendsmixed.fma.module.salesorderitem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.customeritem.CustomerItem;
import com.trendsmixed.fma.module.salesorder.SalesOrder;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SalesOrderItemService {

    private SalesOrderItemRepository repository;

    public Iterable<SalesOrderItem> findAll() {
        return repository.findAll();
    }
    public Page<SalesOrderItem> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public SalesOrderItem save(SalesOrderItem salesOrderItem) {
        return repository.save(salesOrderItem);
    }

    public SalesOrderItem findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Page<SalesOrderItem>findBySalesOrderOrderDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySalesOrderOrderDateBetween(startDate, endDate, pageable);

    }
    
    public Page<SalesOrderItem> findBySalesOrderCustomerAndSalesOrderOrderDateBetween(Customer customer, Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySalesOrderCustomerAndSalesOrderOrderDateBetween(customer, startDate, endDate, pageable);
    }

    public Page<SalesOrderItem> findByCustomerItemAndSalesOrderOrderDateBetween(CustomerItem customerItem, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByCustomerItemAndSalesOrderOrderDateBetween(customerItem, startDate, endDate, pageable);
    }

    public Page<SalesOrderItem> findByCustomerItemAndSalesOrderOrderDateBetweenAndSalesOrderCustomer(CustomerItem customerItem, Date startDate, Date endDate, Customer customer, Pageable pageable) {
        return repository.findByCustomerItemAndSalesOrderOrderDateBetweenAndSalesOrderCustomer(customerItem, startDate, endDate, customer, pageable);
    }

    public Page<SalesOrderItem> findBySalesOrderAndSalesOrderOrderDateBetween(SalesOrder salesOrder, Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySalesOrderAndSalesOrderOrderDateBetween(salesOrder, startDate, endDate, pageable);
    }

    public Page<SalesOrderItem> findByCustomerItemAndSalesOrderOrderDateBetweenAndSalesOrder(CustomerItem customerItem, Date startDate, Date endDate, SalesOrder salesOrder, Pageable pageable) {
        return repository.findByCustomerItemAndSalesOrderOrderDateBetweenAndSalesOrder(customerItem, startDate, endDate, salesOrder, pageable);
    }

    public Page<SalesOrderItem> findBySalesOrderAndSalesOrderOrderDateBetweenAndSalesOrderCustomer(SalesOrder salesOrder, Date startDate, Date endDate, Customer customer, Pageable pageable) {
        return repository.findBySalesOrderAndSalesOrderOrderDateBetweenAndSalesOrderCustomer(salesOrder, startDate, endDate, customer, pageable);
    }

    public Page<SalesOrderItem> findBySalesOrderCustomerAndCustomerItemAndSalesOrderAndAndSalesOrderOrderDateBetween(Customer customer,CustomerItem customerItem,SalesOrder salesOrder, Date startDate, Date endDate,  Pageable pageable) {
        return repository.findBySalesOrderCustomerAndCustomerItemAndSalesOrderAndAndSalesOrderOrderDateBetween(customer,customerItem,salesOrder, startDate, endDate,  pageable);
    }
   


}
