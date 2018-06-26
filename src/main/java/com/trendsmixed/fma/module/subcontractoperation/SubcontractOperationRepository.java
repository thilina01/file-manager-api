package com.trendsmixed.fma.module.subcontractoperation;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.subcontractnote.SubcontractNote;

public interface SubcontractOperationRepository extends PagingAndSortingRepository<SubcontractOperation, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,CONCAT(o.id,''),'')"
                        + " FROM SubcontractOperation o")
        List<Combo> getCombo();

        Iterable<SubcontractOperation> findBySubcontractNote(SubcontractNote subcontractNote);

}
