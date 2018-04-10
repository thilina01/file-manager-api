package com.trendsmixed.fma.module.exchangerate;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.currency.Currency;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
        repository.save(exchangeRates);
    }

    public ExchangeRate findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public ExchangeRate findOneByCurrencyAndExchangeRateDate(Currency currency, Date exchangeRateDate) {
        return repository.findOneByCurrencyAndExchangeRateDate(currency, exchangeRateDate);
    }
  
}
