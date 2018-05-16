package com.trendsmixed.fma.module.itemtype;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface ItemTypeRepository extends PagingAndSortingRepository<ItemType, Integer> {

    ItemType findByName(String name);

    ItemType findByCode(String code);

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)" + " FROM ItemType o")
    List<Combo> getCombo();
}
