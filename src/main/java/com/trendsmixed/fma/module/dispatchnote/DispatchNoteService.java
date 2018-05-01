package com.trendsmixed.fma.module.dispatchnote;
import com.trendsmixed.fma.module.location.Location;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import java.util.List;
import java.util.Date;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DispatchNoteService {

    private DispatchNoteRepository repository;

    public Iterable<DispatchNote> findAll() {
        return repository.findAll();
    }

    public Page<DispatchNote> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public DispatchNote save(DispatchNote dispatchNote) {
        return repository.save(dispatchNote);
    }

    public void save(List<DispatchNote> countries) {
        repository.save(countries);
    }

    public DispatchNote findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    // public List<Combo> getComboByCustomer(Customer customer) {
    //     return repository.getComboByCustomer(customer);
    // }

    public Iterable<DispatchNote> findByCustomer(Customer customer) {
        return repository.findByCustomer(customer);
    }

    public Iterable<DispatchNote> findByCustomerAndInvoiceIsNull(Customer customer) {
        return repository.findByCustomerAndInvoiceIsNull(customer);
    }
    public DispatchNote findById(String id) {
        return repository.findById(id);
    }

    public Page<DispatchNote> findByDispatchDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByDispatchDateBetween(startDate, endDate, pageable);

    }
    public Page<DispatchNote> findByDispatchDateAndLocation(Date date, Location location, Pageable pageable) {
        return repository.findByDispatchDateAndLocation(date, location, pageable);
    }
    public Page<DispatchNote> findByDispatchDateBetweenAndLocation(Date startDate, Date endDate, Location location, Pageable pageable) {
        return repository.findByDispatchDateBetweenAndLocation(startDate, endDate, location, pageable);
    }
    public Page<DispatchNote> findByCustomerAndDispatchDateBetween(Customer customer, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByCustomerAndDispatchDateBetween(customer, startDate, endDate, pageable);
    }
    public Page<DispatchNote> findByCustomerAndDispatchDateAndLocation(Customer customer, Date date, Location location, Pageable pageable) {
        return repository.findByCustomerAndDispatchDateAndLocation(customer, date, location, pageable);

    }
    public Page<DispatchNote> findByCustomerAndDispatchDateBetweenAndLocation(Customer customer, Date startDate, Date endDate, Location location, Pageable pageable) {
        return repository.findByCustomerAndDispatchDateBetweenAndLocation(customer, startDate, endDate, location, pageable);
    }
    public Page<DispatchNote> findByDispatchDateAndCustomer(Date date, Customer customer, Pageable pageable) {
        return repository.findByDispatchDateAndCustomer(date, customer, pageable);
    }
 
}
