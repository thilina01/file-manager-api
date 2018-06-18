package com.trendsmixed.fma.module.treatmenttype;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TreatmentTypeService {

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

    public void save(List<TreatmentType> treatmentTypes) {
        repository.save(treatmentTypes);
    }

    public TreatmentType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
