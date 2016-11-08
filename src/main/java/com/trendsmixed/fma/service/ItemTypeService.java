package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.ItemType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.ItemTypeRepository;

@Service
public class ItemTypeService {

    @Autowired
    private ItemTypeRepository ItemTypeRepository;

    public List<ItemType> findAll() {
        return ItemTypeRepository.findAll();
    }

    public ItemType save(ItemType itemType) {
        return ItemTypeRepository.save(itemType);
    }

    public void save(List<ItemType> items) {
        ItemTypeRepository.save(items);
    }

    public ItemType findOne(int id) {
        return ItemTypeRepository.findOne(id);
    }

    public void delete(int id) {
        ItemTypeRepository.delete(id);
    }

    public ItemType findByType(String type) {
        return ItemTypeRepository.findByType(type);
    }
}
