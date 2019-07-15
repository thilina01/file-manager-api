package com.trendsmixed.fma.module.rawmaterial;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RawMaterialService {

    private RawMaterialRepository repository;

    public Iterable<RawMaterial> findAll() {
        return repository.findAll();
    }

    public Page<RawMaterial> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public RawMaterial save(RawMaterial rawMaterial) {
        return repository.save(rawMaterial);
    }

    public void save(List<RawMaterial> rawMaterials) {
        repository.save(rawMaterials);
    }

    public RawMaterial findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public RawMaterial findByName(String name) {
        return repository.findByName(name);
    }
}
