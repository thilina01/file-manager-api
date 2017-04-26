package com.trendsmixed.fma.module.paint;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.ItemType;
import com.trendsmixed.fma.entity.Paint;

public interface PaintRepository extends PagingAndSortingRepository<Paint, Integer> {

    public Paint findByCode(String code);

    public Paint findByDescription(String description);
    
	@Query(value = "SELECT"
			+ " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.description)"
			+ " FROM Paint o")
	public List<Combo> getCombo();
}
