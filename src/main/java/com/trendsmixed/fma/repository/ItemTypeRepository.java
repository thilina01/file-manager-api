package com.trendsmixed.fma.repository;

import com.trendsmixed.fma.entity.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemTypeRepository extends JpaRepository<ItemType, Integer> {

    public ItemType findByType(String type);

}
