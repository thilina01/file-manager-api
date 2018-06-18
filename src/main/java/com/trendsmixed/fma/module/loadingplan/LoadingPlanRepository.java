package com.trendsmixed.fma.module.loadingplan;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LoadingPlanRepository extends PagingAndSortingRepository<LoadingPlan, Integer> {

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, '', '')" + " FROM LoadingPlan o")
    List<Combo> getCombo();

    // @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,CONCAT(o.id,''), '')" + " FROM LoadingPlan o"
    //         + " WHERE o.customer = :customer")
    // List<Combo> getComboByCustomer(@Param("customer") Customer customer);

    Iterable<LoadingPlan> findByCustomer(Customer customer);

}
