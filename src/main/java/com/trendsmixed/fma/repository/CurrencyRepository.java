package com.trendsmixed.fma.repository;

import com.trendsmixed.fma.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

}