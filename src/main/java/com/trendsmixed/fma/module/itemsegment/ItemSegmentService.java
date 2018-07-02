package com.trendsmixed.fma.module.itemsegment;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ItemSegmentService {

    private ItemSegmentRepository repository;

    public Iterable<ItemSegment> findAll() {
        return repository.findAll();
    }

    public Page<ItemSegment> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public ItemSegment save(ItemSegment customerType) {
        return repository.save(customerType);
    }

    public ItemSegment findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public ItemSegment findByCode(String code) {
        return repository.findByCode(code);
    }

    public ItemSegment findByName(String name) {
        return repository.findByName(name);
    }
}
