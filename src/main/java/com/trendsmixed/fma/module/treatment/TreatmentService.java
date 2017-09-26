package com.trendsmixed.fma.module.treatment;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TreatmentService {

    @Autowired
    private TreatmentRepository repository;

    public Iterable<Treatment> findAll() {
        return repository.findAll();
    }

    public Page<Treatment> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Treatment save(Treatment treatment) {
        return repository.save(treatment);
    }

    public Treatment findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Treatment findByCode(String code) {
        return repository.findByCode(code);
    }
}
