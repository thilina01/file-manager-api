package com.trendsmixed.fma.module.menutype;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MenuTypeRepository extends PagingAndSortingRepository<MenuType, Integer> {

    MenuType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM MenuType o")
    List<Combo> getCombo();
}
