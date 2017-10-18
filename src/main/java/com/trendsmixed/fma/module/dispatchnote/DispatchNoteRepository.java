package com.trendsmixed.fma.module.dispatchnote;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DispatchNoteRepository extends PagingAndSortingRepository<DispatchNote, Integer> {

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id,'','')"
            + " FROM DispatchNote o")
    public List<Combo> getCombo();

}
