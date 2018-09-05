package com.trendsmixed.fma.module.debitnoteitem;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DebitNoteItemRepository extends PagingAndSortingRepository<DebitNoteItem, Integer> {

        @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,CONCAT(o.id,''),'')"
                        + " FROM DebitNoteItem o")
        List<Combo> getCombo();

}
