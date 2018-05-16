package com.trendsmixed.fma.module.item;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.itemtype.ItemType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepository extends PagingAndSortingRepository<Item, Integer> {

    Item findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.description)"
            + " FROM Item o")
    List<Combo> getCombo();

    Page<Item> findByItemType(ItemType itemType, Pageable pageable);

}
