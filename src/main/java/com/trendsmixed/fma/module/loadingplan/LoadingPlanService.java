package com.trendsmixed.fma.module.loadingplan;

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
public class LoadingPlanService {

    private LoadingPlanRepository repository;

    public Iterable<LoadingPlan> findAll() {
        return repository.findAll();
    }

    public Page<LoadingPlan> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public LoadingPlan save(LoadingPlan loadingPlan) {
        return repository.save(loadingPlan);
    }

    public LoadingPlan findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Iterable<LoadingPlan> findByCustomer(Customer customer) {
        return repository.findByCustomer(customer);
    }
    
    public Iterable<LoadingPlan> findByDispatchNoteId(int id) {
        return repository.findByDispatchNoteId(id);
    }
    
    public Page<LoadingPlan>findByLoadingPlanDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByLoadingPlanDateBetween(startDate, endDate, pageable);
    }

    public Page<LoadingPlan> findByCustomerAndLoadingPlanDateBetween(Customer customer, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByCustomerAndLoadingPlanDateBetween(customer, startDate, endDate, pageable);
    }
}
