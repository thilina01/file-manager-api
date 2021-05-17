package com.trendsmixed.fma.module.subcontractoperationdefinition;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.operationtype.OperationType;
import com.trendsmixed.fma.module.producttype.ProductType;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@AllArgsConstructor
@Service
public class SubcontractOperationDefinitionService {

    private SubcontractOperationDefinitionRepository repository;

    public Iterable<SubcontractOperationDefinition> findAll() {
        return repository.findAll();
    }

    public Page<SubcontractOperationDefinition> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public SubcontractOperationDefinition save(SubcontractOperationDefinition subcontractOperationDefinition) {
        return repository.save(subcontractOperationDefinition);
    }

    public void save(List<SubcontractOperationDefinition> subcontractOperationDefinitionList) {
        repository.saveAll(subcontractOperationDefinitionList);
    }

    public SubcontractOperationDefinition findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Page<SubcontractOperationDefinition> findByItem(Item item,Pageable pageable) {
        return repository.findByItem(item ,pageable);
    }

    public Page<SubcontractOperationDefinition> findByOperationType(OperationType operationType,Pageable pageable) {
        return repository.findByOperationType(operationType,pageable);
    }

    public Page<SubcontractOperationDefinition> findByProductType(ProductType productType,Pageable pageable) {
        return repository.findByProductType(productType, pageable);
    }

    public Page<SubcontractOperationDefinition> findByOperationTypeAndItemAndProductType(OperationType operationType ,Item item,ProductType productType,Pageable pageable) {
        return repository.findByOperationTypeAndItemAndProductType(operationType,item,productType, pageable);
    }

    public Page<SubcontractOperationDefinition> findByProductTypeAndItem(ProductType productType,Item item,Pageable pageable) {
        return repository.findByProductTypeAndItem(productType,item, pageable);
    }

    public Page<SubcontractOperationDefinition> findByOperationTypeAndItem(OperationType operationType,Item item,Pageable pageable) {
        return repository.findByOperationTypeAndItem(operationType,item,pageable);
    }


    public Page<SubcontractOperationDefinition> findByOperationTypeAndProductType(OperationType operationType,ProductType productType,Pageable pageable) {
        return repository.findByOperationTypeAndProductType(operationType,productType, pageable);
    }
	
   
}
