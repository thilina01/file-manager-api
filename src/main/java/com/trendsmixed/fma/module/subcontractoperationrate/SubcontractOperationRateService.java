package com.trendsmixed.fma.module.subcontractoperationrate;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinition;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;
import com.trendsmixed.fma.module.subcontractoroperation.SubcontractorOperation;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@AllArgsConstructor
@Service
public class SubcontractOperationRateService {

    private SubcontractOperationRateRepository repository;

    public Iterable<SubcontractOperationRate> findAll() {
        return repository.findAll();
    }

    public Page<SubcontractOperationRate> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SubcontractOperationRate save(SubcontractOperationRate subcontractOperationRate) {
        return repository.save(subcontractOperationRate);
    }

    public void save(List<SubcontractOperationRate> subcontractOperationRateList) {
        repository.save(subcontractOperationRateList);
    }

    public SubcontractOperationRate findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
    public Page<SubcontractOperationRate> findBySubcontractorOperationSubcontractor( Subcontractor subcontractor, Pageable pageable) {
        return repository.findBySubcontractorOperationSubcontractor( subcontractor, pageable);
    }

    public Page<SubcontractOperationRate> findBySubcontractorOperationSubcontractOperationDefinition( SubcontractOperationDefinition subcontractOperationDefinition, Pageable pageable) {
        return repository.findBySubcontractorOperationSubcontractOperationDefinition( subcontractOperationDefinition, pageable);
    }

    public Page<SubcontractOperationRate> findBySubcontractorOperationSubcontractorAndSubcontractorOperationSubcontractOperationDefinition(Subcontractor subcontractor,SubcontractOperationDefinition subcontractOperationDefinition,Pageable pageable) {
        return repository.findBySubcontractorOperationSubcontractorAndSubcontractorOperationSubcontractOperationDefinition(subcontractor, subcontractOperationDefinition, pageable);
    }

    public Iterable<SubcontractOperationRate> findBySubcontractorOperationSubcontractor(Subcontractor subcontractor) {
        return repository.findBySubcontractorOperationSubcontractor(subcontractor);
    }
   
    public Iterable<SubcontractOperationRate> findBySubcontractorOperationSubcontractorIdAndSubcontractorOperationSubcontractorOperationDefinitionItemId(int subcontractorId, int itemId) {
        return repository.findBySubcontractorOperationSubcontractorIdAndSubcontractorOperationSubcontractOperationDefinitionItemId(subcontractorId, itemId);
    }

    public SubcontractOperationRate findFirstBySubcontractorOperationOrderByDateOfRateDesc(SubcontractorOperation subcontractorOperation) {
        return repository.findFirstBySubcontractorOperationOrderByDateOfRateDesc(subcontractorOperation);
    }
   
}
