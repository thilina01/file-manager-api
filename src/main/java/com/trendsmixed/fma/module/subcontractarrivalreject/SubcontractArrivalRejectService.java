package com.trendsmixed.fma.module.subcontractarrivalreject;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@AllArgsConstructor
@Service
public class SubcontractArrivalRejectService {

    private SubcontractArrivalRejectRepository repository;

    public Iterable<SubcontractArrivalReject> findAll() {
        return repository.findAll();
    }

    public Page<SubcontractArrivalReject> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SubcontractArrivalReject save(SubcontractArrivalReject subcontractArrivalReject) {
        return repository.save(subcontractArrivalReject);
    }

    public void save(List<SubcontractArrivalReject> subcontractArrivalRejectList) {
        repository.save(subcontractArrivalRejectList);
    }

    public SubcontractArrivalReject findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
   
}
