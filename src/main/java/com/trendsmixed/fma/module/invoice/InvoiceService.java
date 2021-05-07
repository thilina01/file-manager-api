package com.trendsmixed.fma.module.invoice;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class InvoiceService {

    private InvoiceRepository repository;

    public Iterable<Invoice> findAll() {
        return repository.findAll();
    }

    public Page<Invoice> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Invoice save(Invoice invoice) {
        return repository.save(invoice);
    }

    public Invoice findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Page<Invoice> findByInvoiceDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByInvoiceDateBetween(startDate, endDate, pageable);

    }

    public Page<Invoice> findByCustomerAndInvoiceDateBetween(Customer customer, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByCustomerAndInvoiceDateBetween(customer, startDate, endDate, pageable);
    }

    public Page<Invoice> findByCustomer(Customer customer,  Pageable pageable) {
        return repository.findByCustomer(customer,  pageable);
    }

    Page<Invoice> findByInvoiceNumber(String invoiceNumber, Pageable pageable) {
        return repository.findByInvoiceNumber(invoiceNumber, pageable);
    }

    //  public Page<Invoice> findByDispatchDateAndCustomer(Date date, Customer customer, Pageable pageable) {
    //     return repository.findByDispatchDateAndCustomer(date, customer, pageable);
    // }

}
