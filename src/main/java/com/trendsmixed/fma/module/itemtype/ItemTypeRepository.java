package com.trendsmixed.fma.module.itemtype;

import com.trendsmixed.fma.entity.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemTypeRepository extends JpaRepository<ItemType, Integer> {

    public ItemType findByType(String type);

}
