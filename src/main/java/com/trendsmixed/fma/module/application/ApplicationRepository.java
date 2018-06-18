package com.trendsmixed.fma.module.application;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ApplicationRepository extends PagingAndSortingRepository<Application, Integer> {

    Application findByCode(String code);

    Application findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Application o")
    List<Combo> getCombo();
}
