package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.PurchaseOrderHasItem;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.PurchaseOrderHasItemRepository;

@Service
public class PurchaseOrderHasItemService {

	@Autowired
	private PurchaseOrderHasItemRepository purchaseOrderHasItemRepository;

	public List<PurchaseOrderHasItem> findAll() {
		return purchaseOrderHasItemRepository.findAll();
	}

	public PurchaseOrderHasItem save(PurchaseOrderHasItem purchaseOrderHasItem) {
		return purchaseOrderHasItemRepository.save(purchaseOrderHasItem);
	}

	public PurchaseOrderHasItem findOne(int id) {
		return purchaseOrderHasItemRepository.findOne(id);
	}
	
	public void delete(int id) {
		purchaseOrderHasItemRepository.delete(id);
	}
}
