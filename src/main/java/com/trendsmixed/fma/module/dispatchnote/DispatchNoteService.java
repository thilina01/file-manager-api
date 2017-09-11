package com.trendsmixed.fma.module.dispatchnote;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DispatchNoteService {

    @Autowired
    private DispatchNoteRepository repository;

    public Iterable<DispatchNote> findAll() {
        return repository.findAll();
    }

    public Page<DispatchNote> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public DispatchNote save(DispatchNote dispatchNote) {
        return repository.save(dispatchNote);
    }

    public void save(List<DispatchNote> countries) {
        repository.save(countries);
    }

    public DispatchNote findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    
}
