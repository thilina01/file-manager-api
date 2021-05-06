package com.trendsmixed.fma.module.treatment;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TreatmentService {

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

    public Treatment findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Treatment findByCode(String code) {
        return repository.findByCode(code);
    }
}
