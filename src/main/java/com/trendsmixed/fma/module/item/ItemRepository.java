package com.trendsmixed.fma.module.item;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface ItemRepository extends PagingAndSortingRepository<Item, Integer> {

    public Item findByCode(String code);
    
	@Query(value = "SELECT"
			+ " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.description)"
			+ " FROM Item o")
	public List<Combo> getCombo();
}
