package com.trendsmixed.fma.module.subcontractor;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SubcontractorService {

    private SubcontractorRepository repository;

    public Iterable<Subcontractor> findAll() {
        return repository.findAll();
    }

    public Page<Subcontractor> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Subcontractor save(Subcontractor subcontractor) {
        return repository.save(subcontractor);
    }

    public Subcontractor findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
