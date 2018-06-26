package com.trendsmixed.fma.module.subcontractoroperation;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubcontractorOperationRepository extends PagingAndSortingRepository<SubcontractorOperation, Integer> {

        @Query(value = "SELECT"
                        + " new com.trendsmixed.fma.dao.Combo(o.id,o.subcontractor.name,CONCAT(o.subcontractOperationDefinition.item.code ,' : ', o.subcontractOperationDefinition.item.description,' : ',o.subcontractOperationDefinition.productType.code,' : ',o.subcontractOperationDefinition.operationType.code))"
                        + " FROM SubcontractorOperation o")
        List<Combo> getCombo();

        Page<SubcontractorOperation> findBySubcontractor(Subcontractor subcontractor, Pageable pageable);

        Iterable<SubcontractorOperation> findBySubcontractor(Subcontractor subcontractor);

}