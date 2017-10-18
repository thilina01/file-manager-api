package com.trendsmixed.fma.module.sectiontype;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SectionTypeRepository extends PagingAndSortingRepository<SectionType, Integer> {

    public SectionType findByCode(String code);

    public SectionType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM SectionType o")
    public List<Combo> getCombo();

}
