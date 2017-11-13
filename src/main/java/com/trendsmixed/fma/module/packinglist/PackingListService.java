package com.trendsmixed.fma.module.packinglist;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PackingListService {

    private PackingListRepository repository;

    public Iterable<PackingList> findAll() {
        return repository.findAll();
    }

    public Page<PackingList> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public PackingList save(PackingList packingList) {
        return repository.save(packingList);
    }

    public void save(List<PackingList> countries) {
        repository.save(countries);
    }

    public PackingList findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public PackingList findById(String id) {
        return repository.findById(id);
    }

}
