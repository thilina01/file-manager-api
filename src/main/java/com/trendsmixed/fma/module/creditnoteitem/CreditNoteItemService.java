package com.trendsmixed.fma.module.creditnoteitem;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class CreditNoteItemService {

    private CreditNoteItemRepository repository;

    public Iterable<CreditNoteItem> findAll() {
        return repository.findAll();
    }

    public Page<CreditNoteItem> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public CreditNoteItem save(CreditNoteItem creditNoteItem) {
        return repository.save(creditNoteItem);
    }

    public void save(List<CreditNoteItem> creditNoteItemList) {
        repository.saveAll(creditNoteItemList);
    }

    public CreditNoteItem findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
