package com.trendsmixed.fma.module.salesorderitem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.item.Item;
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

    public Page<SalesOrderItem> findByCustomerItemItemAndSalesOrderOrderDateBetween(Item item, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByCustomerItemItemAndSalesOrderOrderDateBetween(item, startDate, endDate, pageable);
    }

    public Page<SalesOrderItem> findByCustomerItemItemAndSalesOrderOrderDateBetweenAndSalesOrderCustomer(Item item, Date startDate, Date endDate, Customer customer, Pageable pageable) {
        return repository.findByCustomerItemItemAndSalesOrderOrderDateBetweenAndSalesOrderCustomer(item, startDate, endDate, customer, pageable);
    }

    public Page<SalesOrderItem> findBySalesOrderAndSalesOrderOrderDateBetween(SalesOrder salesOrder, Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySalesOrderAndSalesOrderOrderDateBetween(salesOrder, startDate, endDate, pageable);
    }

    public Page<SalesOrderItem> findByCustomerItemItemAndSalesOrderOrderDateBetweenAndSalesOrder(Item item, Date startDate, Date endDate, SalesOrder salesOrder, Pageable pageable) {
        return repository.findByCustomerItemItemAndSalesOrderOrderDateBetweenAndSalesOrder(item, startDate, endDate, salesOrder, pageable);
    }

    public Page<SalesOrderItem> findBySalesOrderAndSalesOrderOrderDateBetweenAndSalesOrderCustomer(SalesOrder salesOrder, Date startDate, Date endDate, Customer customer, Pageable pageable) {
        return repository.findBySalesOrderAndSalesOrderOrderDateBetweenAndSalesOrderCustomer(salesOrder, startDate, endDate, customer, pageable);
    }

    public Page<SalesOrderItem> findBySalesOrderCustomerAndCustomerItemItemAndSalesOrderAndAndSalesOrderOrderDateBetween(Customer customer,Item item,SalesOrder salesOrder, Date startDate, Date endDate,  Pageable pageable) {
        return repository.findBySalesOrderCustomerAndCustomerItemItemAndSalesOrderAndAndSalesOrderOrderDateBetween(customer,item,salesOrder, startDate, endDate,  pageable);
    }
   


}
