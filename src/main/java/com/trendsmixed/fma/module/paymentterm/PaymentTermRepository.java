package com.trendsmixed.fma.module.paymentterm;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PaymentTermRepository extends PagingAndSortingRepository<PaymentTerm, Integer> {

    PaymentTerm findByCode(String code);

    PaymentTerm findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM PaymentTerm o")
    List<Combo> getCombo();
}
