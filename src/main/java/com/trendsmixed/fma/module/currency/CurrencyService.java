package com.trendsmixed.fma.module.currency;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CurrencyService {

    private CurrencyRepository repository;

    public Iterable<Currency> findAll() {
        return repository.findAll();
    }

    public Page<Currency> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Currency save(Currency currency) {
        return repository.save(currency);
    }

    public Currency findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Currency findByCode(String code) {
        return repository.findByCode(code);
    }

    public Currency findOneByCustomerListId(int id) {
        return repository.findOneByCustomerListId(id);
    }
}
