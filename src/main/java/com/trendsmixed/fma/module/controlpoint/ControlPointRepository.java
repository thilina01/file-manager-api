package com.trendsmixed.fma.module.controlpoint;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface ControlPointRepository extends PagingAndSortingRepository<ControlPoint, Integer> {

	public ControlPoint findByCode(String code);

	@Query(value = "SELECT"
			+ " new com.trendsmixed.fma.dao.Combo(controlPoint.id, controlPoint.code, controlPoint.name)"
			+ " FROM ControlPoint controlPoint")
	public List<Combo> getCombo();

}
