package com.trendsmixed.fma.module.subcontractreworkoperation;

import com.trendsmixed.fma.dao.Combo;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@AllArgsConstructor
@Service
public class SubcontractReworkOperationService {

    private SubcontractReworkOperationRepository repository;

    public Iterable<SubcontractReworkOperation> findAll() {
        return repository.findAll();
    }

    public Page<SubcontractReworkOperation> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SubcontractReworkOperation save(SubcontractReworkOperation subcontractReworkOperation) {
        return repository.save(subcontractReworkOperation);
    }

    public void save(List<SubcontractReworkOperation> subcontractReworkOperationList) {
        repository.save(subcontractReworkOperationList);
    }

    public SubcontractReworkOperation findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
