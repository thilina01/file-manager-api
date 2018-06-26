package com.trendsmixed.fma.module.subcontractoperationrate;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinition;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;
import com.trendsmixed.fma.module.subcontractoroperation.SubcontractorOperation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubcontractOperationRateRepository
                extends PagingAndSortingRepository<SubcontractOperationRate, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,CONCAT(o.id,''),'')"
                        + " FROM SubcontractOperationRate o")
        List<Combo> getCombo();

        Page<SubcontractOperationRate> findBySubcontractorOperationSubcontractor(Subcontractor subcontractor,
                        Pageable pageable);

        Page<SubcontractOperationRate> findBySubcontractorOperationSubcontractOperationDefinition(
                        SubcontractOperationDefinition subcontractOperationDefinition, Pageable pageable);

        Page<SubcontractOperationRate> findBySubcontractorOperationSubcontractorAndSubcontractorOperationSubcontractOperationDefinition(
                        Subcontractor subcontractor, SubcontractOperationDefinition subcontractOperationDefinition,
                        Pageable pageable);

        Iterable<SubcontractOperationRate> findBySubcontractorOperationSubcontractor(Subcontractor subcontractor);

        Iterable<SubcontractOperationRate> findBySubcontractorOperationSubcontractorIdAndSubcontractorOperationSubcontractOperationDefinitionItemId(
                        int subcontractorId, int itemId);

        SubcontractOperationRate findFirstBySubcontractorOperationOrderByDateOfRateDesc(
                        SubcontractorOperation subcontractorOperation);

}
