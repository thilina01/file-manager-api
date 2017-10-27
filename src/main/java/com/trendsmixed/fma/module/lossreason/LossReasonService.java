package com.trendsmixed.fma.module.lossreason;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.losstype.LossType;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@AllArgsConstructor
@Service
public class LossReasonService {

    private LossReasonRepository repository;

    public Iterable<LossReason> findAll() {
        return repository.findAll();
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public List<Combo> getComboByLossType(LossType lossType) {
        return repository.getComboByLossType(lossType);
    }

    public Page<LossReason> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public LossReason save(LossReason lossReason) {
        return repository.save(lossReason);
    }

    public void save(List<LossReason> lossReasons) {
        repository.save(lossReasons);
    }

    public LossReason findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public LossReason findByCode(String code) {
        return repository.findByCode(code);
    }

    Page<LossReason> findByLossType(LossType lossType, Pageable pageable) {
        return repository.findByLossType(lossType, pageable);
    }
}
