package com.trendsmixed.fma.module.invoicetype;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface InvoiceTypeRepository extends PagingAndSortingRepository<InvoiceType, Integer> {

    public InvoiceType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM InvoiceType o")
    List<Combo> getCombo();
}
