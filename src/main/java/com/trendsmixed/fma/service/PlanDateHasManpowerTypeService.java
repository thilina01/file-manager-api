package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.PlanDateHasManpowerType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.PlanDateHasManpowerTypeRepository;

@Service
public class PlanDateHasManpowerTypeService {

	@Autowired
	private PlanDateHasManpowerTypeRepository panDateHasManpowerTypeRepository;

	public List<PlanDateHasManpowerType> findAll() {
		return panDateHasManpowerTypeRepository.findAll();
	}

	public PlanDateHasManpowerType save(PlanDateHasManpowerType planDateHasManpowerType) {
		return panDateHasManpowerTypeRepository.save(planDateHasManpowerType);
	}

	public PlanDateHasManpowerType findOne(int id) {
		return panDateHasManpowerTypeRepository.findOne(id);
	}
	
	public void delete(int id) {
		panDateHasManpowerTypeRepository.delete(id);
	}
}
