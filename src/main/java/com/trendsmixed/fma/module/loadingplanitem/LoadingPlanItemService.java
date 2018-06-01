package com.trendsmixed.fma.module.loadingplanitem;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import java.util.Date;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.job.Job;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@AllArgsConstructor
@Service
public class LoadingPlanItemService {

    private LoadingPlanItemRepository repository;

    public Iterable<LoadingPlanItem> findAll() {
        return repository.findAll();
    }

    public Page<LoadingPlanItem> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public LoadingPlanItem save(LoadingPlanItem loadingPlanItem) {
        return repository.save(loadingPlanItem);
    }

    public LoadingPlanItem findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    Page<LoadingPlanItem> findByLoadingPlanDispatchNoteCustomer(Customer customer, Pageable pageable) {
        return repository.findByLoadingPlanDispatchNoteCustomer(customer, pageable);
    }

    Page<LoadingPlanItem> findByDispatchScheduleJobItem(Item item, Pageable pageable) {
        return repository.findByDispatchScheduleJobItem(item, pageable);
    }

    public Page<LoadingPlanItem>findByLoadingPlanDispatchNoteDispatchDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByLoadingPlanDispatchNoteDispatchDateBetween(startDate, endDate, pageable);
    }

    public Page<LoadingPlanItem> findByLoadingPlanDispatchNoteDispatchDateAndDispatchScheduleJobItem(Date date, Item item, Pageable pageable) {
        return repository.findByLoadingPlanDispatchNoteDispatchDateAndDispatchScheduleJobItem(date, item, pageable);
    }

    public Page<LoadingPlanItem> findByLoadingPlanDispatchNoteDispatchDateBetweenAndDispatchScheduleJobItem(Date startDate, Date endDate, Item item, Pageable pageable) {
        return repository.findByLoadingPlanDispatchNoteDispatchDateBetweenAndDispatchScheduleJobItem(startDate, endDate, item, pageable);
    }

    public Page<LoadingPlanItem> findByLoadingPlanDispatchNoteCustomerAndLoadingPlanDispatchNoteDispatchDateBetween(Customer customer, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByLoadingPlanDispatchNoteCustomerAndLoadingPlanDispatchNoteDispatchDateBetween(customer, startDate, endDate, pageable);
    }

    public Page<LoadingPlanItem> findByLoadingPlanDispatchNoteCustomerAndLoadingPlanDispatchNoteDispatchDateAndDispatchScheduleJobItem(Customer customer, Date date, Item item, Pageable pageable) {
        return repository.findByLoadingPlanDispatchNoteCustomerAndLoadingPlanDispatchNoteDispatchDateAndDispatchScheduleJobItem(customer, date, item, pageable);
    }

    public Page<LoadingPlanItem> findByLoadingPlanDispatchNoteCustomerAndLoadingPlanDispatchNoteDispatchDateBetweenAndDispatchScheduleJobItem(Customer customer, Date startDate, Date endDate, Item item, Pageable pageable) {
        return repository.findByLoadingPlanDispatchNoteCustomerAndLoadingPlanDispatchNoteDispatchDateBetweenAndDispatchScheduleJobItem(customer, startDate, endDate, item, pageable);
    }

    public Page<LoadingPlanItem> findByLoadingPlanDispatchNoteInvoiceNotNull( Pageable pageable) {
        return repository.findByLoadingPlanDispatchNoteInvoiceNotNull( pageable);
    }

    public Page<LoadingPlanItem>findByLoadingPlanDispatchNoteInvoiceInvoiceDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByLoadingPlanDispatchNoteInvoiceInvoiceDateBetween(startDate, endDate, pageable);
    }

    public Page<LoadingPlanItem> findByLoadingPlanDispatchNoteInvoiceInvoiceNumber(String invoiceNumber, Pageable pageable) {
        return repository.findByLoadingPlanDispatchNoteInvoiceInvoiceNumber(invoiceNumber, pageable);
    }

    public Page<LoadingPlanItem> findByLoadingPlanDispatchNoteInvoiceCustomerAndLoadingPlanDispatchNoteInvoiceInvoiceDateBetween(Customer customer, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByLoadingPlanDispatchNoteInvoiceCustomerAndLoadingPlanDispatchNoteInvoiceInvoiceDateBetween(customer, startDate, endDate, pageable);
    }

    public Page<LoadingPlanItem> findByDispatchScheduleJobAndLoadingPlanDispatchNoteInvoiceInvoiceDateBetween(Job job, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByDispatchScheduleJobAndLoadingPlanDispatchNoteInvoiceInvoiceDateBetween(job, startDate, endDate, pageable);
    }

}
