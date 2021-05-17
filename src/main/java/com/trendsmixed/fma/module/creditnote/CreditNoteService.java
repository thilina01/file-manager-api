package com.trendsmixed.fma.module.creditnote;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CreditNoteService {

    private CreditNoteRepository repository;

    public Iterable<CreditNote> findAll() {
        return repository.findAll();
    }

    public Page<CreditNote> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public CreditNote save(CreditNote creditNote) {
        return repository.save(creditNote);
    }

    public CreditNote findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
    public List<Combo> getCombo() {
        return repository.getCombo();
    }
}
