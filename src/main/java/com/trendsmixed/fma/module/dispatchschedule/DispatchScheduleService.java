package com.trendsmixed.fma.module.dispatchschedule;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.salesorder.SalesOrder;
import com.trendsmixed.fma.module.job.Job;
import java.util.List;
import java.util.Date;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DispatchScheduleService {

    private DispatchScheduleRepository repository;

    public Iterable<DispatchSchedule> findAll() {
        return repository.findAll();
    }

    public Page<DispatchSchedule> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public List<Combo> getComboByCustomer(Customer customer) {
        return repository.getComboByCustomer(customer);
    }

    public DispatchSchedule save(DispatchSchedule dispatchSchedule) {
        return repository.save(dispatchSchedule);
    }

    public Iterable<DispatchSchedule> save(List<DispatchSchedule> dispatchSchedules) {
        return repository.save(dispatchSchedules);
    }

    public DispatchSchedule findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Iterable<DispatchSchedule> findBySalesOrderItemSalesOrder(SalesOrder salesOrder) {
        return repository.findBySalesOrderItemSalesOrder(salesOrder);
    }

    public Iterable<DispatchSchedule> findBySalesOrderItemSalesOrderCustomer(Customer customer) {
        return repository.findBySalesOrderItemSalesOrderCustomer(customer);
    }
    public Page<DispatchSchedule>findBySalesOrderItemSalesOrderOrderDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySalesOrderItemSalesOrderOrderDateBetween(startDate, endDate, pageable);

    }
    public Page<DispatchSchedule> findBySalesOrderItemSalesOrderOrderDateAndJob(Date date, Job job, Pageable pageable) {
        return repository.findBySalesOrderItemSalesOrderOrderDateAndJob(date, job, pageable);
    }

    public Page<DispatchSchedule> findBySalesOrderItemSalesOrderOrderDateBetweenAndJob(Date startDate, Date endDate, Job job, Pageable pageable) {
        return repository.findBySalesOrderItemSalesOrderOrderDateBetweenAndJob(startDate, endDate, job, pageable);
    }
   
    public Page<DispatchSchedule> findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateBetween(Customer customer, Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateBetween(customer, startDate, endDate, pageable);
    }
    public Page<DispatchSchedule> findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateAndJob(Customer customer, Date date, Job job, Pageable pageable) {
        return repository.findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateAndJob(customer, date, job, pageable);

    }
    public Page<DispatchSchedule> findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateBetweenAndJob(Customer customer, Date startDate, Date endDate, Job job, Pageable pageable) {
        return repository.findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateBetweenAndJob(customer, startDate, endDate, job, pageable);
    }

    Page<DispatchSchedule> findBySalesOrderItemSalesOrderCustomer(Customer customer, Pageable pageable) {
        return repository.findBySalesOrderItemSalesOrderCustomer(customer, pageable);
    }

    Page<DispatchSchedule> findByJob(Job job, Pageable pageable) {
        return repository.findByJob(job, pageable);
}


}
