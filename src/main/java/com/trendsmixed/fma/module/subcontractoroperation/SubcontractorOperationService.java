package com.trendsmixed.fma.module.subcontractoroperation;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@AllArgsConstructor
@Service
public class SubcontractorOperationService {

    private SubcontractorOperationRepository repository;

    public Iterable<SubcontractorOperation> findAll() {
        return repository.findAll();
    }

    public Page<SubcontractorOperation> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SubcontractorOperation save(SubcontractorOperation subcontractorOperation) {
        return repository.save(subcontractorOperation);
    }

    public void save(List<SubcontractorOperation> subcontractorOperationList) {
        repository.save(subcontractorOperationList);
    }

    public SubcontractorOperation findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
    
    public Page<SubcontractorOperation> findBySubcontractor(Subcontractor subcontractor,  Pageable pageable) {
        return repository.findBySubcontractor(subcontractor, pageable);
    }

    public Iterable<SubcontractorOperation> findBySubcontractor(Subcontractor subcontractor) {
        return repository.findBySubcontractor(subcontractor);
    }

}
