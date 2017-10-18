package com.trendsmixed.fma.module.dispatch;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class DispatchService {

    @Autowired
    private DispatchRepository repository;

    public Iterable<Dispatch> findAll() {
        return repository.findAll();
    }

    public Page<Dispatch> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Dispatch save(Dispatch dispatch) {
        return repository.save(dispatch);
    }

    public Dispatch findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
