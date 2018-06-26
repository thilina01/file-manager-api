package com.trendsmixed.fma.module.subcontractarrival;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@AllArgsConstructor
@Service
public class SubcontractArrivalService {

    private SubcontractArrivalRepository repository;

    public Iterable<SubcontractArrival> findAll() {
        return repository.findAll();
    }

    public Page<SubcontractArrival> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SubcontractArrival save(SubcontractArrival subcontractArrival) {
        return repository.save(subcontractArrival);
    }

    public void save(List<SubcontractArrival> subcontractArrivalList) {
        repository.save(subcontractArrivalList);
    }

    public SubcontractArrival findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
   
}
