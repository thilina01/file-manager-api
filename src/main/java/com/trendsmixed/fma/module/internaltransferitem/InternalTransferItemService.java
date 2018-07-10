package com.trendsmixed.fma.module.internaltransferitem;

import com.trendsmixed.fma.dao.Combo;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@AllArgsConstructor
@Service
public class InternalTransferItemService {

    private InternalTransferItemRepository repository;

    public Iterable<InternalTransferItem> findAll() {
        return repository.findAll();
    }

    public Page<InternalTransferItem> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public InternalTransferItem save(InternalTransferItem internalTransferItem) {
        return repository.save(internalTransferItem);
    }

    public void save(List<InternalTransferItem> internalTransferItemList) {
        repository.save(internalTransferItemList);
    }

    public InternalTransferItem findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
