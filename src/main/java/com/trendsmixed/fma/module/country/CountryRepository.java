package com.trendsmixed.fma.module.country;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CountryRepository extends PagingAndSortingRepository<Country, Integer> {

    Country findByCode(String code);

    Country findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Country o")
    List<Combo> getCombo();
}
