package com.trendsmixed.fma.module.currency;

import com.trendsmixed.fma.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

    public Currency findByCode(String code);

}
