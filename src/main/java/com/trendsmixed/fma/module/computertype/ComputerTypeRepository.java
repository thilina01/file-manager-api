package com.trendsmixed.fma.module.computertype;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ComputerTypeRepository extends PagingAndSortingRepository<ComputerType, Integer> {

    ComputerType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM ComputerType o")
    List<Combo> getCombo();
}
