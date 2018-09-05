package com.trendsmixed.fma.module.debitnote;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DebitNoteRepository extends PagingAndSortingRepository<DebitNote, Integer> {

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, '', '')" + " FROM DebitNote o")

    List<Combo> getCombo();
}