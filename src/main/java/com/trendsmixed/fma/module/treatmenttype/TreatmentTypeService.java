package com.trendsmixed.fma.module.treatmenttype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.domain.Page;

@Service
public class TreatmentTypeService {

    @Autowired
    private TreatmentTypeRepository repository;

    public Iterable<TreatmentType> findAll() {
        return repository.findAll();
    }

    public Page<TreatmentType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public TreatmentType save(TreatmentType treatmentType) {
        return repository.save(treatmentType);
    }

    public void save(List<TreatmentType> items) {
        repository.save(items);
    }

    public TreatmentType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}