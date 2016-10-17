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

    public ItemType save(ItemType ItemType) {
        return ItemTypeRepository.save(ItemType);
    }

    public ItemType findOne(int id) {
        return ItemTypeRepository.findOne(id);
    }

    public void delete(int id) {
        ItemTypeRepository.delete(id);
    }
}
