package com.trendsmixed.fma.module.creditnote;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CreditNoteRepository extends PagingAndSortingRepository<CreditNote, Integer> {

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, '', '')" + " FROM CreditNote o")

    List<Combo> getCombo();
}