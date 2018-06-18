package com.trendsmixed.fma.module.palletsize;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PalletSizeService {

    private PalletSizeRepository repository;

    public Iterable<PalletSize> findAll() {
        return repository.findAll();
    }

    public Page<PalletSize> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public PalletSize save(PalletSize palletSize) {
        return repository.save(palletSize);
    }

    public PalletSize findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
    public List<Combo> getCombo() {
        return repository.getCombo();
    }
}
