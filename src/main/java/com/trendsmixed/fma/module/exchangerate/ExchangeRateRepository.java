package com.trendsmixed.fma.module.exchangerate;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.currency.Currency;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExchangeRateRepository extends PagingAndSortingRepository<ExchangeRate, Integer> {

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, '', '')" + " FROM ExchangeRate o")
    List<Combo> getCombo();
    
    ExchangeRate findOneByCurrencyAndExchangeRateDate(Currency currency, Date exchangeRateDate);
}
