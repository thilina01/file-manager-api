package com.trendsmixed.fma.module.itemtype;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ItemTypeService {

    private ItemTypeRepository repository;

    public Iterable<ItemType> findAll() {
        return repository.findAll();
    }

    public Page<ItemType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public ItemType save(ItemType itemType) {
        return repository.save(itemType);
    }

    public void save(List<ItemType> itemTypes) {
        repository.saveAll(itemTypes);
    }

    public ItemType findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public ItemType findByName(String name) {
        return repository.findByName(name);
    }

    public ItemType findByCode(String code) {
        return repository.findByCode(code);
    }

}
