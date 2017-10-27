package com.trendsmixed.fma.module.deliveryterm;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface DeliveryTermRepository extends PagingAndSortingRepository<DeliveryTerm, Integer> {

    DeliveryTerm findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM DeliveryTerm o")
    List<Combo> getCombo();
}
