package com.trendsmixed.fma.module.itemtype;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface ItemTypeRepository extends PagingAndSortingRepository<ItemType, Integer> {

    public ItemType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM ItemType o")
    public List<Combo> getCombo();
}
