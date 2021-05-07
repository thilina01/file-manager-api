package com.trendsmixed.fma.module.costcenter;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CostCenterService {

    private CostCenterRepository repository;

    public Iterable<CostCenter> findAll() {
        return repository.findAll();
    }

    public Page<CostCenter> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public CostCenter save(CostCenter costCenter) {
        return repository.save(costCenter);
    }

    public void save(List<CostCenter> costCenters) {
        repository.saveAll(costCenters);
    }

    public CostCenter findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public CostCenter findByCode(String code) {
        return repository.findByCode(code);
    }

}
