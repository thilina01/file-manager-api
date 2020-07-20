package com.trendsmixed.fma.module.creditnote;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class CreditNoteService {

    private CreditNoteRepository repository;


    public Iterable<CreditNote> findAll() {
        return repository.findAll();
    }
    
    public Page<CreditNote> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public CreditNote save(CreditNote creditNote) {
        return repository.save(creditNote);
    }

    public CreditNote findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
    
    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public  Page<CreditNote> getCreditNoteByDateBetween(Date startDate, Date endDate,Pageable pageable) {
        return repository.getCreditNoteByDateBetween(startDate, endDate,pageable);
    }
}

