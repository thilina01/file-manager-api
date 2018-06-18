package com.trendsmixed.fma.module.exchangerate;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.currency.Currency;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ExchangeRateRepository extends PagingAndSortingRepository<ExchangeRate, Integer> {

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, '', '')" + " FROM ExchangeRate o")
    List<Combo> getCombo();
    
    ExchangeRate findOneByCurrencyAndExchangeRateDate(Currency currency, Date exchangeRateDate);

    @Query(value = "SELECT exchangeRate"
                        + " FROM ExchangeRate exchangeRate"
                        + " WHERE exchangeRate.currency= :currency AND exchangeRate.exchangeRateDate BETWEEN :startDate AND :endDate"
                        + " ORDER BY exchangeRate.exchangeRateDate DESC")
        List findOneByCurrencyAndExchangeRateBetween( @Param("currency") Currency currency,@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
