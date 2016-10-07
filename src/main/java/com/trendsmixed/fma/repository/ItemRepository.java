package com.trendsmixed.fma.repository;

import com.trendsmixed.fma.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Integer> {


}
