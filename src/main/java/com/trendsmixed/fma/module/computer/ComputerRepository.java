package com.trendsmixed.fma.module.computer;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ComputerRepository extends PagingAndSortingRepository<Computer, Integer> {

    public Computer findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code,o.brand)"
            + " FROM Computer o")
    public List<Combo> getCombo();
}
