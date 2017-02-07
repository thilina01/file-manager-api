package com.trendsmixed.fma.module.item;

import com.trendsmixed.fma.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    public Item findByCode(String code);

}
