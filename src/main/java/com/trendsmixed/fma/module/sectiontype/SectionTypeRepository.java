package com.trendsmixed.fma.module.sectiontype;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SectionTypeRepository extends PagingAndSortingRepository<SectionType, Integer> {

    SectionType findByCode(String code);

    SectionType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM SectionType o")
    List<Combo> getCombo();

}
