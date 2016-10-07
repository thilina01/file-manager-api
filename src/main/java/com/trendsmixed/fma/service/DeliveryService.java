package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.Delivery;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.DeliveryRepository;

@Service
public class DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepository;

	public List< Delivery> findAll() {
		return deliveryRepository.findAll();
	}

	public  Delivery save( Delivery  delivery) {
		return deliveryRepository.save( delivery);
	}

	public  Delivery findOne(int id) {
		return deliveryRepository.findOne(id);
	}
	
	public void delete(int id) {
		deliveryRepository.delete(id);
	}
}
