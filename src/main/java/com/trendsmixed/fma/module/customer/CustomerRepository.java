package com.trendsmixed.fma.module.customer;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

    Customer findByCode(String code);

    Customer findByName(String name);

    Customer findByShortName(String shortName);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Customer o")
    List<Combo> getCombo();
}
