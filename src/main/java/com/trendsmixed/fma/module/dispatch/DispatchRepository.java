package com.trendsmixed.fma.module.dispatch;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.item.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface DispatchRepository extends PagingAndSortingRepository<Dispatch, Integer> {

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,'','')" + " FROM Dispatch o")
    List<Combo> getCombo();

    Page<Dispatch> findByDispatchNoteCustomer(Customer customer, Pageable pageable);

    Page<Dispatch> findByDispatchScheduleJobItem(Item item, Pageable pageable);

    Page<Dispatch> findByDispatchNoteDispatchDateBetween(Date startDate, Date endDate, Pageable pageable);

    Page<Dispatch> findByDispatchNoteDispatchDateAndDispatchScheduleJobItem(Date date, Item item, Pageable pageable);

    Page<Dispatch> findByDispatchNoteDispatchDateBetweenAndDispatchScheduleJobItem(Date startDate, Date endDate,
            Item item, Pageable pageable);

    Page<Dispatch> findByDispatchNoteCustomerAndDispatchNoteDispatchDateBetween(Customer customer, Date startDate,
            Date endDate, Pageable pageable);

    Page<Dispatch> findByDispatchNoteCustomerAndDispatchNoteDispatchDateAndDispatchScheduleJobItem(Customer customer,
            Date date, Item item, Pageable pageable);

    Page<Dispatch> findByDispatchNoteCustomerAndDispatchNoteDispatchDateBetweenAndDispatchScheduleJobItem(
            Customer customer, Date startDate, Date endDate, Item item, Pageable pageable);
}
