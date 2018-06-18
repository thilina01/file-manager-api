package com.trendsmixed.fma.module.customertype;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CustomerTypeRepository extends PagingAndSortingRepository<CustomerType, Integer> {

    CustomerType findByCode(String code);

    CustomerType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM CustomerType o")
    List<Combo> getCombo();
}
