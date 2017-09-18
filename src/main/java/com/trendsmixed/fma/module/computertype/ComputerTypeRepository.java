package com.trendsmixed.fma.module.computertype;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface ComputerTypeRepository extends PagingAndSortingRepository<ComputerType, Integer> {

    public ComputerType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM ComputerType o")
    public List<Combo> getCombo();
}
