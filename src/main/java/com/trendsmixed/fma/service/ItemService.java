package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.Item;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	public Item save(Item item) {
		return itemRepository.save(item);
	}

	public Item findOne(int id) {
		return itemRepository.findOne(id);
	}
	
	public void delete(int id) {
		itemRepository.delete(id);
	}
}
