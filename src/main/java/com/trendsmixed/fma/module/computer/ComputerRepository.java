package com.trendsmixed.fma.module.computer;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ComputerRepository extends PagingAndSortingRepository<Computer, Integer> {

    Computer findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code,o.brand)"
            + " FROM Computer o")
    List<Combo> getCombo();
}
