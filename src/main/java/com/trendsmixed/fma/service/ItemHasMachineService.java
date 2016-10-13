package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.ItemHasMachine;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.ItemHasMachineRepository;

@Service
public class ItemHasMachineService {

    @Autowired
    private ItemHasMachineRepository defectTypeRepository;

    public List<ItemHasMachine> findAll() {
        return defectTypeRepository.findAll();
    }

    public ItemHasMachine save(ItemHasMachine itemHasMachine) {
        return defectTypeRepository.save(itemHasMachine);
    }

    public ItemHasMachine findOne(int id) {
        return defectTypeRepository.findOne(id);
    }

    public void delete(int id) {
        defectTypeRepository.delete(id);
    }
}
