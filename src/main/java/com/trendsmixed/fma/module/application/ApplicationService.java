package com.trendsmixed.fma.module.application;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository repository;

    public Iterable<Application> findAll() {
        return repository.findAll();
    }

    public Page<Application> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Application save(Application application) {
        return repository.save(application);
    }

    public Application findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Application findByCode(String code) {
        return repository.findByCode(code);
    }
}
