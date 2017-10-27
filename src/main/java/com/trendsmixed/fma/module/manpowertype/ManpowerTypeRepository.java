package com.trendsmixed.fma.module.manpowertype;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ManpowerTypeRepository extends PagingAndSortingRepository<ManpowerType, Integer> {

    ManpowerType findByCode(String code);

    ManpowerType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM ManpowerType o")
    List<Combo> getCombo();
}
