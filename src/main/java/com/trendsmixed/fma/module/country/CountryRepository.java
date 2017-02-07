package com.trendsmixed.fma.module.country;

import com.trendsmixed.fma.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    public Country findByCode(String code);

    public Country findByName(String name);

}
