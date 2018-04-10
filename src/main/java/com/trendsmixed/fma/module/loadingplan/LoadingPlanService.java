package com.trendsmixed.fma.module.loadingplan;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LoadingPlanService {

    private LoadingPlanRepository repository;

    public Iterable<LoadingPlan> findAll() {
        return repository.findAll();
    }

    public Page<LoadingPlan> findAll(Pageable pageable) {
        return new Page<LoadingPlan>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public LoadingPlan save(LoadingPlan loadingPlan) {
        return repository.save(loadingPlan);
    }

    public LoadingPlan findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Iterable<LoadingPlan> findByCustomer(Customer customer) {
        return repository.findByCustomer(customer);
    }
}
