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

    public ItemSegment save(ItemSegment itemSegment) {
        return repository.save(itemSegment);
    }

    public ItemSegment findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public ItemSegment findByCode(String code) {
        return repository.findByCode(code);
    }

    public ItemSegment findByName(String name) {
        return repository.findByName(name);
    }
}
