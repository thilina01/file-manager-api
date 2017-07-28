package com.trendsmixed.fma.module.paymentterm;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentTermRepository extends PagingAndSortingRepository<PaymentTerm, Integer> {

    public PaymentTerm findByCode(String code);

    public PaymentTerm findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM PaymentTerm o")
    public List<Combo> getCombo();
}
