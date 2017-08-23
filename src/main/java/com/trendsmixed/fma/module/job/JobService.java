package com.trendsmixed.fma.module.job;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.salesorder.SalesOrder;
import com.trendsmixed.fma.utility.Page;

@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    public Iterable<Job> findAll() {
        return repository.findAll();
    }

    public Page<Job> findAll(Pageable pageable) {
        return new Page<Job>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Job save(Job job) {
        return repository.save(job);
    }

    public Iterable<Job> save(List<Job> jobs) {
        return repository.save(jobs);
    }

    public Job findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Job findByJobNo(String jobNo) {
        return repository.findByJobNo(jobNo);
    }

    public List findX(Date startDate, Date endDate, Pageable pageable) {
        return repository.findX(startDate, endDate, pageable);
    }

    public List findForTable() {
        return repository.findForTable();
    }

    Iterable<Job> findBySalesOrderItemSalesOrder(SalesOrder salesOrder) {
        return repository.findBySalesOrderItemSalesOrder(salesOrder);
    }

}
