package com.trendsmixed.fma.module.currency;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CurrencyRepository extends PagingAndSortingRepository<Currency, Integer> {

    Currency findByCode(String code);

    Currency findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Currency o")
    List<Combo> getCombo();

    Currency findOneByCustomerListId(int id);

}
