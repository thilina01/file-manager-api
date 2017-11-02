package com.trendsmixed.fma.module.invoice;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InvoiceService {

    private InvoiceRepository repository;

    public Iterable<Invoice> findAll() {
        return repository.findAll();
    }

    public Page<Invoice> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Invoice save(Invoice invoice) {
        return repository.save(invoice);
    }

    public Invoice findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
