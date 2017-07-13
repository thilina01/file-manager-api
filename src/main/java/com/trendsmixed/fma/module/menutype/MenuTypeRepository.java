package com.trendsmixed.fma.module.menutype;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.MenuType;

public interface MenuTypeRepository extends PagingAndSortingRepository<MenuType, Integer> {

    public MenuType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM MenuType o")
    public List<Combo> getCombo();
}
