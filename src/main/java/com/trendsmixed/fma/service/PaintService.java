package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.Paint;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.PaintRepository;

@Service
public class PaintService {

	@Autowired
	private PaintRepository paintRepository;

	public List<Paint> findAll() {
		return paintRepository.findAll();
	}

	public Paint save(Paint paint) {
		return paintRepository.save(paint);
	}

	public Paint findOne(int id) {
		return paintRepository.findOne(id);
	}
	
	public void delete(int id) {
		paintRepository.delete(id);
	}
}
