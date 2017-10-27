package com.trendsmixed.fma.module.dispatchschedule;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.salesorder.SalesOrder;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DispatchScheduleService {

    private DispatchScheduleRepository repository;

    public Iterable<DispatchSchedule> findAll() {
        return repository.findAll();
    }

    public Page<DispatchSchedule> findAll(Pageable pageable) {
        return new Page<DispatchSchedule>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public List<Combo> getComboByCustomer(Customer customer) {
        return repository.getComboByCustomer(customer);
    }

    public DispatchSchedule save(DispatchSchedule dispatchSchedule) {
        return repository.save(dispatchSchedule);
    }

    public Iterable<DispatchSchedule> save(List<DispatchSchedule> dispatchSchedules) {
        return repository.save(dispatchSchedules);
    }

    public DispatchSchedule findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Iterable<DispatchSchedule> findBySalesOrderItemSalesOrder(SalesOrder salesOrder) {
        return repository.findBySalesOrderItemSalesOrder(salesOrder);
    }
}
