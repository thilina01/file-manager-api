package com.trendsmixed.fma.module.materialtype;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MaterialTypeService {

    private MaterialTypeRepository repository;

    public Iterable<MaterialType> findAll() {
        return repository.findAll();
    }

    public Page<MaterialType> findAll(Pageable pageable) {
        return new Page<MaterialType>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public MaterialType save(MaterialType materialType) {
        return repository.save(materialType);
    }

    public MaterialType findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public MaterialType findByCode(String code) {
        return repository.findByCode(code);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
