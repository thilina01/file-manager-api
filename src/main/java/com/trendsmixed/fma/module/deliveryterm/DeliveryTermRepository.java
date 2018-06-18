package com.trendsmixed.fma.module.deliveryterm;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DeliveryTermRepository extends PagingAndSortingRepository<DeliveryTerm, Integer> {

    DeliveryTerm findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM DeliveryTerm o")
    List<Combo> getCombo();
}
