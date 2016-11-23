package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.Currency;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.CurrencyRepository;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

    public Currency save(Currency currency) {
        return currencyRepository.save(currency);
    }

    public Currency findOne(int id) {
        return currencyRepository.findOne(id);
    }

    public void delete(int id) {
        currencyRepository.delete(id);
    }

    public Currency findByCode(String code) {
        return currencyRepository.findByCode(code);
    }
}
