package com.trendsmixed.fma.module.customer;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

    public Customer findByCode(String code);

    public Customer findByName(String name);

    public Customer findByShortName(String shortName);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Customer o")
    public List<Combo> getCombo();
}
