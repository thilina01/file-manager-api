package com.trendsmixed.fma.module.loadingplanitem;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.dispatchnote.DispatchNote;
import com.trendsmixed.fma.module.dispatchschedule.DispatchSchedule;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.job.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface LoadingPlanItemRepository extends PagingAndSortingRepository<LoadingPlanItem, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,CONCAT(o.id,''),'')"
                        + " FROM LoadingPlanItem o")
        List<Combo> getCombo();

        Iterable<LoadingPlanItem> findByLoadingPlanDispatchNote(DispatchNote dispatchNote);

        Iterable<LoadingPlanItem> findByDispatchSchedule(DispatchSchedule dispatchSchedule);

        Page<LoadingPlanItem> findByLoadingPlanDispatchNoteCustomer(Customer customer, Pageable pageable);

        Page<LoadingPlanItem> findByDispatchScheduleJobItem(Item item, Pageable pageable);

        Page<LoadingPlanItem> findByLoadingPlanDispatchNoteDispatchDateBetween(Date startDate, Date endDate,
                        Pageable pageable);

        Page<LoadingPlanItem> findByLoadingPlanDispatchNoteDispatchDateAndDispatchScheduleJobItem(Date date, Item item,
                        Pageable pageable);

        Page<LoadingPlanItem> findByLoadingPlanDispatchNoteDispatchDateBetweenAndDispatchScheduleJobItem(Date startDate,
                        Date endDate, Item item, Pageable pageable);

        Page<LoadingPlanItem> findByLoadingPlanDispatchNoteCustomerAndLoadingPlanDispatchNoteDispatchDateBetween(
                        Customer customer, Date startDate, Date endDate, Pageable pageable);

        Page<LoadingPlanItem> findByLoadingPlanDispatchNoteCustomerAndLoadingPlanDispatchNoteDispatchDateAndDispatchScheduleJobItem(
                        Customer customer, Date date, Item item, Pageable pageable);

        Page<LoadingPlanItem> findByLoadingPlanDispatchNoteCustomerAndLoadingPlanDispatchNoteDispatchDateBetweenAndDispatchScheduleJobItem(
                        Customer customer, Date startDate, Date endDate, Item item, Pageable pageable);

        Page<LoadingPlanItem> findByLoadingPlanDispatchNoteInvoiceNotNull(Pageable pageable);

        Page<LoadingPlanItem> findByLoadingPlanDispatchNoteInvoiceInvoiceDateBetween(Date startDate, Date endDate,
                        Pageable pageable);

        Page<LoadingPlanItem> findByLoadingPlanDispatchNoteInvoiceInvoiceNumber(String invoiceNumber,
                        Pageable pageable);

        Page<LoadingPlanItem> findByLoadingPlanDispatchNoteInvoiceCustomerAndLoadingPlanDispatchNoteInvoiceInvoiceDateBetween(
                        Customer customer, Date startDate, Date endDate, Pageable pageable);

        Page<LoadingPlanItem> findByDispatchScheduleJobAndLoadingPlanDispatchNoteInvoiceInvoiceDateBetween(Job job,
                        Date startDate, Date endDate, Pageable pageable);

        Page<LoadingPlanItem> findByLoadingPlanDispatchNoteAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(
                        DispatchNote dispatchNote, Date startDate, Date endDate, Pageable pageable);

        Page<LoadingPlanItem> findByLoadingPlanDispatchNoteCustomerAndLoadingPlanDispatchNoteAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(
                        Customer customer, DispatchNote dispatchNote, Date startDate, Date endDate, Pageable pageable);

        Page<LoadingPlanItem> findByLoadingPlanDispatchNoteAndDispatchScheduleJobItemAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(
                        DispatchNote dispatchNote, Item item, Date startDate, Date endDate, Pageable pageable);

        Page<LoadingPlanItem> findByLoadingPlanDispatchNoteCustomerAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(
                        Customer customer, Date startDate, Date endDate, Pageable pageable);

        Page<LoadingPlanItem> findByDispatchScheduleJobItemAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(
                        Item item, Date startDate, Date endDate, Pageable pageable);

        Page<LoadingPlanItem> findByLoadingPlanDispatchNoteCustomerAndDispatchScheduleJobItemAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(
                        Customer customer, Item item, Date startDate, Date endDate, Pageable pageable);

        Page<LoadingPlanItem> findByRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(Date startDate,
                        Date endDate, Pageable pageable);

        Page<LoadingPlanItem> findByLoadingPlanDispatchNoteCustomerAndDispatchScheduleJobItemAndLoadingPlanDispatchNoteAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(
                        Customer customer, Item item, DispatchNote dispatchNote, Date startDate, Date endDate,
                        Pageable pageable);

        Iterable<LoadingPlanItem> findByLoadingPlanDispatchNoteInvoiceId(int invoiceId);

}
