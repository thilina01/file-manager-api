package com.trendsmixed.fma.module.pack;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PackService {

    private PackRepository repository;

    public Iterable<Pack> findAll() {
        return repository.findAll();
    }

    public Page<Pack> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Pack save(Pack pack) {
        return repository.save(pack);
    }

    public void save(List<Pack> packs) {
        repository.save(packs);
    }

    public Pack findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
