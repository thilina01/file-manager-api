package com.trendsmixed.fma.module.losstype;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

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

    public LossType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public LossType findByCode(String code) {
        return repository.findByCode(code);
    }
}
