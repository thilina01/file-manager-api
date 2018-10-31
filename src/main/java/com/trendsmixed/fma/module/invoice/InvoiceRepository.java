package com.trendsmixed.fma.module.invoice;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Integer> {

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, o.invoiceNumber, '')" + " FROM Invoice o")
    List<Combo> getCombo();

    Page<Invoice> findByInvoiceDateBetween(Date startDate, Date endDate, Pageable pageable);

    Page<Invoice> findByCustomerAndInvoiceDateBetween(Customer customer, Date startDate, Date endDate,
            Pageable pageable);

    Page<Invoice> findByCustomer(Customer customer, Pageable pageable);

    Page<Invoice> findByInvoiceNumber(String invoiceNumber, Pageable pageable);

}
