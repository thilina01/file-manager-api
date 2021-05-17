package com.trendsmixed.fma.module.application;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ApplicationService {

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

    public Application findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Application findByCode(String code) {
        return repository.findByCode(code);
    }
}
