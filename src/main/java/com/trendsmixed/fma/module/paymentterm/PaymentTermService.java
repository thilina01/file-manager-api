package com.trendsmixed.fma.module.paymentterm;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PaymentTermService {

    private PaymentTermRepository repository;

    public Iterable<PaymentTerm> findAll() {
        return repository.findAll();
    }

    public Page<PaymentTerm> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public PaymentTerm save(PaymentTerm paymentTerm) {
        return repository.save(paymentTerm);
    }

    public PaymentTerm findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public PaymentTerm findByCode(String code) {
        return repository.findByCode(code);
    }
}
