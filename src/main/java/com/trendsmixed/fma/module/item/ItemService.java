package com.trendsmixed.fma.module.item;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.itemtype.ItemType;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ItemService {

    private ItemRepository repository;

    public Iterable<Item> findAll() {
        return repository.findAll();
    }

    public Page<Item> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Item save(Item item) {
        return repository.save(item);
    }

    public void save(List<Item> items) {
        repository.saveAll(items);
    }

    public Item findById(int id) {
        return repository.findById(id).get();
    }

    public Item findByCode(String code) {
        return repository.findByCode(code);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }


    Page<Item> findByItemType(ItemType itemType, Pageable pageable) {
        return repository.findByItemType(itemType, pageable);
    }

    Page<Item> findByCode(String code, Pageable pageable) {
        return repository.findByCode(code, pageable);
    }

    Page<Item> findBySize(String itemSize, Pageable pageable) {
        return repository.findBySize( itemSize, pageable);
    }


}
