package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.ItemMachine;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.ItemMachineRepository;

@Service
public class ItemMachineService {

    @Autowired
    private ItemMachineRepository defectTypeRepository;

    public List<ItemMachine> findAll() {
        return defectTypeRepository.findAll();
    }

    public ItemMachine save(ItemMachine itemMachine) {
        return defectTypeRepository.save(itemMachine);
    }

    public ItemMachine findOne(int id) {
        return defectTypeRepository.findOne(id);
    }

    public void delete(int id) {
        defectTypeRepository.delete(id);
    }
}
