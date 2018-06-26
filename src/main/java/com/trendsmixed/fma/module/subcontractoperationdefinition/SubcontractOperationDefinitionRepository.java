package com.trendsmixed.fma.module.subcontractoperationdefinition;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.operationtype.OperationType;
import com.trendsmixed.fma.module.producttype.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubcontractOperationDefinitionRepository
                extends PagingAndSortingRepository<SubcontractOperationDefinition, Integer> {

        @Query(value = "SELECT"
                        + " new com.trendsmixed.fma.dao.Combo(o.id,o.item.code,CONCAT(o.item.description,' : ',o.productType.code,' : ',o.operationType.code))"
                        + " FROM SubcontractOperationDefinition o")
        List<Combo> getCombo();

        Page<SubcontractOperationDefinition> findByItem(Item item, Pageable pageable);

        Page<SubcontractOperationDefinition> findByOperationType(OperationType operationType, Pageable pageable);

        Page<SubcontractOperationDefinition> findByProductType(ProductType productType, Pageable pageable);

        Page<SubcontractOperationDefinition> findByOperationTypeAndItemAndProductType(OperationType operationType,
                        Item item, ProductType productType, Pageable pageable);

        Page<SubcontractOperationDefinition> findByProductTypeAndItem(ProductType productType, Item item,
                        Pageable pageable);

        Page<SubcontractOperationDefinition> findByOperationTypeAndItem(OperationType operationType, Item item,
                        Pageable pageable);

        Page<SubcontractOperationDefinition> findByOperationTypeAndProductType(OperationType operationType,
                        ProductType productType, Pageable pageable);

}
