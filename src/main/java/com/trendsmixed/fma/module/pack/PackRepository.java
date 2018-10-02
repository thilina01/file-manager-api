package com.trendsmixed.fma.module.pack;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PackRepository extends PagingAndSortingRepository<Pack, Integer> {

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,'', '')" + " FROM Pack o")
    List<Combo> getCombo();
}
