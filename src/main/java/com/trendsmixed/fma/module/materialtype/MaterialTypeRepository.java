package com.trendsmixed.fma.module.materialtype;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MaterialTypeRepository extends PagingAndSortingRepository<MaterialType, Integer> {

    MaterialType findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM MaterialType o")
    List<Combo> getCombo();
}
