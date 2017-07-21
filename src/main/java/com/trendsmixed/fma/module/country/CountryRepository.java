package com.trendsmixed.fma.module.country;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.Country;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository extends PagingAndSortingRepository<Country, Integer> {

    public Country findByCode(String code);

    public Country findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Country o")
    public List<Combo> getCombo();
}
