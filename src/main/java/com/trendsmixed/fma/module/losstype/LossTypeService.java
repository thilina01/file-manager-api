package com.trendsmixed.fma.module.losstype;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LossTypeService {

    private LossTypeRepository repository;

    public Iterable<LossType> findAll() {
        return repository.findAll();
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Page<LossType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public LossType save(LossType lossType) {
        return repository.save(lossType);
    }

    public LossType findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public LossType findByCode(String code) {
        return repository.findByCode(code);
    }
}
