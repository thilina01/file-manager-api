package com.trendsmixed.fma.module.item;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.itemtype.ItemType;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

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
        repository.save(items);
    }

    public Item findOne(int id) {
        return repository.findOne(id);
    }

    public Item findByCode(String code) {
        return repository.findByCode(code);
    }

    public void delete(int id) {
        repository.delete(id);
    }


    Page<Item> findByItemType(ItemType itemType, Pageable pageable) {
        return repository.findByItemType(itemType, pageable);
    }


}
