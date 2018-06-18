package com.trendsmixed.fma.module.dispatchnote;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.location.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface DispatchNoteRepository extends PagingAndSortingRepository<DispatchNote, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, CONCAT(o.id,''),'')" + " FROM DispatchNote o")
        List<Combo> getCombo();
        
        Iterable<DispatchNote> findByCustomer(Customer customer);

        Iterable<DispatchNote> findByCustomerAndInvoiceIsNull(Customer customer);

        DispatchNote findById(String id);

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,'','')" + " FROM  DispatchNote o"
                        + " WHERE o.customer = :customer")
        List<Combo> getComboByCustomer(@Param("customer") Customer customer);

        Page<DispatchNote> findByDispatchDateBetween(Date startDate, Date endDate, Pageable pageable);

        Page<DispatchNote> findByDispatchDateAndLocation(Date date, Location location, Pageable pageable);

        Page<DispatchNote> findByDispatchDateBetweenAndLocation(Date startDate, Date endDate, Location location,
                        Pageable pageable);

        Page<DispatchNote> findByCustomerAndDispatchDateBetween(Customer customer, Date startDate, Date endDate,
                        Pageable pageable);

        Page<DispatchNote> findByCustomerAndDispatchDateAndLocation(Customer customer, Date date, Location location,
                        Pageable pageable);

        Page<DispatchNote> findByCustomerAndDispatchDateBetweenAndLocation(Customer customer, Date startDate,
                        Date endDate, Location location, Pageable pageable);

        Page<DispatchNote> findByDispatchDateAndCustomer(Date date, Customer customer, Pageable pageable);

}
