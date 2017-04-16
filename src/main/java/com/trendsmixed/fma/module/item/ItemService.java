package com.trendsmixed.fma.module.item;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.ControlPoint;
import com.trendsmixed.fma.entity.Item;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.module.item.ItemRepository;
import com.trendsmixed.fma.utility.Page;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Iterable<Item> findAll() {
        return repository.findAll();
    }

	public Page<Item> findAll(Pageable pageable) {
		return new Page<Item>(repository.findAll(pageable));
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

	public List<Combo> getCombo() {
		return repository.getCombo();
	}
}
