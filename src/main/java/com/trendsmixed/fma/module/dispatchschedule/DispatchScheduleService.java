package com.trendsmixed.fma.module.dispatchschedule;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.salesorder.SalesOrder;
import com.trendsmixed.fma.module.salesordertype.SalesOrderType;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class DispatchScheduleService {

    private DispatchScheduleRepository repository;

    public Iterable<DispatchSchedule> findAll() {
        return repository.findAll();
    }

    public Page<DispatchSchedule> findAll(Pageable pageable) {
        return repository.findAll(pageable);
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
        return repository.saveAll(dispatchSchedules);
    }

    public DispatchSchedule findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Iterable<DispatchSchedule> findBySalesOrderItemSalesOrder(SalesOrder salesOrder) {
        return repository.findBySalesOrderItemSalesOrder(salesOrder);
    }

    public Iterable<DispatchSchedule> findBySalesOrderItemSalesOrderCustomer(Customer customer) {
        return repository.findBySalesOrderItemSalesOrderCustomer(customer);
    }
    public Page<DispatchSchedule>findBySalesOrderItemSalesOrderOrderDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySalesOrderItemSalesOrderOrderDateBetween(startDate, endDate, pageable);

    }
    public Page<DispatchSchedule> findBySalesOrderItemSalesOrderOrderDateAndJob(Date date, Job job, Pageable pageable) {
        return repository.findBySalesOrderItemSalesOrderOrderDateAndJob(date, job, pageable);
    }

    public Page<DispatchSchedule> findBySalesOrderItemSalesOrderOrderDateBetweenAndJob(Date startDate, Date endDate, Job job, Pageable pageable) {
        return repository.findBySalesOrderItemSalesOrderOrderDateBetweenAndJob(startDate, endDate, job, pageable);
    }
   
    public Page<DispatchSchedule> findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateBetween(Customer customer, Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateBetween(customer, startDate, endDate, pageable);
    }
    public Page<DispatchSchedule> findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateAndJob(Customer customer, Date date, Job job, Pageable pageable) {
        return repository.findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateAndJob(customer, date, job, pageable);

    }
    public Page<DispatchSchedule> findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateBetweenAndJob(Customer customer, Date startDate, Date endDate, Job job, Pageable pageable) {
        return repository.findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateBetweenAndJob(customer, startDate, endDate, job, pageable);
    }

    Page<DispatchSchedule> findBySalesOrderItemSalesOrderCustomer(Customer customer, Pageable pageable) {
        return repository.findBySalesOrderItemSalesOrderCustomer(customer, pageable);
    }

    Page<DispatchSchedule> findByJob(Job job, Pageable pageable) {
        return repository.findByJob(job, pageable);
}


public Page<DispatchSchedule> findByJobItemAndSalesOrderItemSalesOrderOrderDateBetween(Item item, Date startDate, Date endDate, Pageable pageable) {
    return repository.findByJobItemAndSalesOrderItemSalesOrderOrderDateBetween(item, startDate, endDate, pageable);
}

public Page<DispatchSchedule> findBySalesOrderItemSalesOrderSalesOrderTypeAndSalesOrderItemSalesOrderOrderDateBetween(SalesOrderType salesOrderType, Date startDate, Date endDate, Pageable pageable) {
    return repository.findBySalesOrderItemSalesOrderSalesOrderTypeAndSalesOrderItemSalesOrderOrderDateBetween(salesOrderType, startDate, endDate, pageable);
}

public Page<DispatchSchedule> findByJobItemAndSalesOrderItemSalesOrderOrderDateBetweenAndJob(Item item, Date startDate, Date endDate, Job job, Pageable pageable) {
    return repository.findByJobItemAndSalesOrderItemSalesOrderOrderDateBetweenAndJob(item, startDate, endDate, job, pageable);
}

public Page<DispatchSchedule> findByJobItemAndSalesOrderItemSalesOrderOrderDateBetweenAndSalesOrderItemSalesOrderSalesOrderType(Item item, Date startDate, Date endDate, SalesOrderType salesOrderType, Pageable pageable) {
    return repository.findByJobItemAndSalesOrderItemSalesOrderOrderDateBetweenAndSalesOrderItemSalesOrderSalesOrderType(item, startDate, endDate, salesOrderType, pageable);
}

public Page<DispatchSchedule> findByJobItemAndSalesOrderItemSalesOrderOrderDateBetweenAndSalesOrderItemSalesOrderCustomer(Item item, Date startDate, Date endDate, Customer customer, Pageable pageable) {
    return repository.findByJobItemAndSalesOrderItemSalesOrderOrderDateBetweenAndSalesOrderItemSalesOrderCustomer(item, startDate, endDate, customer, pageable);
}

public Page<DispatchSchedule> findBySalesOrderItemSalesOrderSalesOrderTypeAndSalesOrderItemSalesOrderOrderDateBetweenAndJob(SalesOrderType salesOrderType, Date startDate, Date endDate, Job job, Pageable pageable) {
    return repository.findBySalesOrderItemSalesOrderSalesOrderTypeAndSalesOrderItemSalesOrderOrderDateBetweenAndJob(salesOrderType, startDate, endDate, job, pageable);
}

public Page<DispatchSchedule> findBySalesOrderItemSalesOrderSalesOrderTypeAndSalesOrderItemSalesOrderOrderDateBetweenAndSalesOrderItemSalesOrderCustomer(SalesOrderType salesOrderType, Date startDate, Date endDate, Customer customer, Pageable pageable) {
    return repository.findBySalesOrderItemSalesOrderSalesOrderTypeAndSalesOrderItemSalesOrderOrderDateBetweenAndSalesOrderItemSalesOrderCustomer(salesOrderType, startDate, endDate, customer, pageable);
}

public Page<DispatchSchedule>findByDispatchScheduleDateBetween(Date startDate, Date endDate, Pageable pageable) {
    return repository.findByDispatchScheduleDateBetween(startDate, endDate, pageable);

}

public Page<DispatchSchedule> findByDispatchScheduleDateBetweenAndJob(Date startDate, Date endDate, Job job, Pageable pageable) {
    return repository.findByDispatchScheduleDateBetweenAndJob(startDate, endDate, job, pageable);
}

public Page<DispatchSchedule> findBySalesOrderItemSalesOrderCustomerAndDispatchScheduleDateBetween(Customer customer, Date startDate, Date endDate, Pageable pageable) {
    return repository.findBySalesOrderItemSalesOrderCustomerAndDispatchScheduleDateBetween(customer, startDate, endDate, pageable);
}

public Page<DispatchSchedule> findBySalesOrderItemSalesOrderCustomerAndDispatchScheduleDateBetweenAndJob(Customer customer, Date startDate, Date endDate, Job job, Pageable pageable) {
    return repository.findBySalesOrderItemSalesOrderCustomerAndDispatchScheduleDateBetweenAndJob(customer, startDate, endDate, job, pageable);
}

public Page<DispatchSchedule> findByConfirmDateNotNull( Pageable pageable) {
    return repository.findByConfirmDateNotNull( pageable);
}

Page<DispatchSchedule> findBySalesOrderItemSalesOrderCustomerPoNumber(String customerPoNumber, Pageable pageable) {
    return repository.findBySalesOrderItemSalesOrderCustomerPoNumber(customerPoNumber, pageable);
}

}
