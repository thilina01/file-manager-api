package com.trendsmixed.fma.module.exchangerate;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.currency.Currency;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class ExchangeRateService {

    private ExchangeRateRepository repository;

    public Iterable<ExchangeRate> findAll() {
        return repository.findAll();
    }

    public Page<ExchangeRate> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public ExchangeRate save(ExchangeRate exchangeRate) {
        return repository.save(exchangeRate);
    }

    public void save(List<ExchangeRate>exchangeRates) {
        repository.saveAll(exchangeRates);
    }

    public ExchangeRate findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public ExchangeRate findOneByCurrencyAndExchangeRateDate(Currency currency, Date exchangeRateDate) {
        return repository.findOneByCurrencyAndExchangeRateDate(currency, exchangeRateDate);
    }

    public List findOneByCurrencyAndExchangeRateBetween(Currency currency, Date startDate,Date endDate) {
        return repository.findOneByCurrencyAndExchangeRateBetween(currency, startDate,endDate);
    }
  
}
