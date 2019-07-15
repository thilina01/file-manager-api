package com.trendsmixed.fma.module.rawmaterialitem;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RawMaterialItemService {

    private RawMaterialItemRepository repository;

    public Iterable<RawMaterialItem> findAll() {
        return repository.findAll();
    }

    public Page<RawMaterialItem> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public RawMaterialItem save(RawMaterialItem rawMaterialItem) {
        return repository.save(rawMaterialItem);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public void save(List<RawMaterialItem> onTimeDeliveries) {
        repository.save(onTimeDeliveries);
    }

    public RawMaterialItem findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
