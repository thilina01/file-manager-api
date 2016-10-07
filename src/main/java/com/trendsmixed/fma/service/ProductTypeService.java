package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.ProductType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.ProductTypeRepository;

@Service
public class ProductTypeService {

	@Autowired
	private ProductTypeRepository productTypeRepository;

	public List<ProductType> findAll() {
		return productTypeRepository.findAll();
	}

	public ProductType save(ProductType productType) {
		return productTypeRepository.save(productType);
	}

	public ProductType findOne(int id) {
		return productTypeRepository.findOne(id);
	}
	
	public void delete(int id) {
		productTypeRepository.delete(id);
	}
}
