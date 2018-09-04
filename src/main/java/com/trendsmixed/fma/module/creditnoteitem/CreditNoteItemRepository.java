package com.trendsmixed.fma.module.creditnoteitem;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CreditNoteItemRepository extends PagingAndSortingRepository<CreditNoteItem, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,CONCAT(o.id,''),'')"
                        + " FROM CreditNoteItem o")
        List<Combo> getCombo();

}
