package com.trendsmixed.fma.module.subcontractoperation;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.subcontractnote.SubcontractNote;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@AllArgsConstructor
@Service
public class SubcontractOperationService {

    private SubcontractOperationRepository repository;

    public Iterable<SubcontractOperation> findAll() {
        return repository.findAll();
    }

    public Page<SubcontractOperation> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SubcontractOperation save(SubcontractOperation subcontractOperation) {
        return repository.save(subcontractOperation);
    }

    public void save(List<SubcontractOperation> subcontractOperationList) {
        repository.saveAll(subcontractOperationList);
    }

    public SubcontractOperation findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Iterable<SubcontractOperation> findBySubcontractNote(SubcontractNote subcontractNote) {
        return repository.findBySubcontractNote(subcontractNote);
    }
   
   
}
