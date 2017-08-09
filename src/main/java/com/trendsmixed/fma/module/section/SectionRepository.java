package com.trendsmixed.fma.module.section;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface SectionRepository extends PagingAndSortingRepository<Section, Integer> {

    public Section findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Section o")
    public List<Combo> getCombo();
}
