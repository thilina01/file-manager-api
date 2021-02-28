package com.trendsmixed.fma.module.loadingplanitem;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.dispatchnote.DispatchNote;
import com.trendsmixed.fma.module.dispatchschedule.DispatchSchedule;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.job.Job;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


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

    public void save(List<LoadingPlanItem> loadingPlanItemList) {
        repository.save(loadingPlanItemList);
    }

    public LoadingPlanItem findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
    
    public Iterable<LoadingPlanItem> findByLoadingPlanDispatchNote(DispatchNote dispatchNote) {
        return repository.findByLoadingPlanDispatchNote(dispatchNote);
    }

    public Iterable<LoadingPlanItem> findByDispatchSchedule(DispatchSchedule dispatchSchedule) {
        return repository.findByDispatchSchedule(dispatchSchedule);
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

    public Page<LoadingPlanItem> findByLoadingPlanDispatchNoteAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(DispatchNote dispatchNote,Date startDate, Date endDate,  Pageable pageable) {
        return repository.findByLoadingPlanDispatchNoteAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(dispatchNote,startDate, endDate,  pageable);
    }

    public Page<LoadingPlanItem> findByLoadingPlanDispatchNoteCustomerAndLoadingPlanDispatchNoteAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(Customer customer,DispatchNote dispatchNote, Date startDate, Date endDate,Pageable pageable) {
        return repository.findByLoadingPlanDispatchNoteCustomerAndLoadingPlanDispatchNoteAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(customer,dispatchNote, startDate, endDate, pageable);
    }

    public Page<LoadingPlanItem> findByLoadingPlanDispatchNoteAndDispatchScheduleJobItemAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(DispatchNote dispatchNote,Item item, Date startDate, Date endDate,  Pageable pageable) {
        return repository.findByLoadingPlanDispatchNoteAndDispatchScheduleJobItemAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(dispatchNote,item, startDate, endDate,  pageable);
    }

    public Page<LoadingPlanItem> findByLoadingPlanDispatchNoteCustomerAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(Customer customer, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByLoadingPlanDispatchNoteCustomerAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(customer, startDate, endDate, pageable);
    }

    public Page<LoadingPlanItem> findByDispatchScheduleJobItemAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(Item item,Date startDate, Date endDate,  Pageable pageable) {
        return repository.findByDispatchScheduleJobItemAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(item,startDate, endDate,  pageable);
    }

    public Page<LoadingPlanItem> findByLoadingPlanDispatchNoteCustomerAndDispatchScheduleJobItemAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(Customer customer,Item item, Date startDate, Date endDate,  Pageable pageable) {
        return repository.findByLoadingPlanDispatchNoteCustomerAndDispatchScheduleJobItemAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(customer,item, startDate, endDate,  pageable);
    }

    public Page<LoadingPlanItem>findByRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(startDate, endDate, pageable);
    }

    public Page<LoadingPlanItem> findByLoadingPlanDispatchNoteCustomerAndDispatchScheduleJobItemAndLoadingPlanDispatchNoteAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(Customer customer,Item item,DispatchNote dispatchNote, Date startDate, Date endDate,  Pageable pageable) {
        return repository.findByLoadingPlanDispatchNoteCustomerAndDispatchScheduleJobItemAndLoadingPlanDispatchNoteAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(customer,item,dispatchNote, startDate, endDate,  pageable);
    }

    public Iterable<LoadingPlanItem> findByLoadingPlanDispatchNoteInvoiceId(int invoiceId) {
        return repository.findByLoadingPlanDispatchNoteInvoiceId(invoiceId);
    }
}
