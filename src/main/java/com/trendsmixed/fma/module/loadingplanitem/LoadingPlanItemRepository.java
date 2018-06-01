package com.trendsmixed.fma.module.loadingplanitem;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.job.Job;

import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LoadingPlanItemRepository extends PagingAndSortingRepository<LoadingPlanItem, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,'','')" + " FROM LoadingPlanItem o")
        List<Combo> getCombo();

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

}
