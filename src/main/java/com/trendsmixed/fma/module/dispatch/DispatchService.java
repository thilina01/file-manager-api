package com.trendsmixed.fma.module.dispatch;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.item.Item;
import java.util.Date;
import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@AllArgsConstructor
@Service
public class DispatchService {

    private DispatchRepository repository;

    public Iterable<Dispatch> findAll() {
        return repository.findAll();
    }

    public Page<Dispatch> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Dispatch save(Dispatch dispatch) {
        return repository.save(dispatch);
    }

    public Dispatch findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
    Page<Dispatch> findByDispatchNoteCustomer(Customer customer, Pageable pageable) {
        return repository.findByDispatchNoteCustomer(customer, pageable);
    }
    Page<Dispatch> findByDispatchScheduleJobItem(Item item, Pageable pageable) {
        return repository.findByDispatchScheduleJobItem(item, pageable);
    }
    public Page<Dispatch> findByDispatchNoteDispatchDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByDispatchNoteDispatchDateBetween(startDate, endDate, pageable);
    }
    public Page<Dispatch> findByDispatchNoteDispatchDateAndDispatchScheduleJobItem(Date date, Item item, Pageable pageable) {
        return repository.findByDispatchNoteDispatchDateAndDispatchScheduleJobItem(date, item, pageable);
    }
    public Page<Dispatch> findByDispatchNoteDispatchDateBetweenAndDispatchScheduleJobItem(Date startDate, Date endDate, Item item, Pageable pageable) {
        return repository.findByDispatchNoteDispatchDateBetweenAndDispatchScheduleJobItem(startDate, endDate, item, pageable);
    }
    public Page<Dispatch> findByDispatchNoteCustomerAndDispatchNoteDispatchDateBetween(Customer customer, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByDispatchNoteCustomerAndDispatchNoteDispatchDateBetween(customer, startDate, endDate, pageable);
    }
    public Page<Dispatch> findByDispatchNoteCustomerAndDispatchNoteDispatchDateAndDispatchScheduleJobItem(Customer customer, Date date, Item item, Pageable pageable) {
        return repository.findByDispatchNoteCustomerAndDispatchNoteDispatchDateAndDispatchScheduleJobItem(customer, date, item, pageable);
    }
    public Page<Dispatch> findByDispatchNoteCustomerAndDispatchNoteDispatchDateBetweenAndDispatchScheduleJobItem(Customer customer, Date startDate, Date endDate, Item item, Pageable pageable) {
        return repository.findByDispatchNoteCustomerAndDispatchNoteDispatchDateBetweenAndDispatchScheduleJobItem(customer, startDate, endDate, item, pageable);
    }
}
