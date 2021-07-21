package com.trendsmixed.fma.module.arbranch;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ArBranchService {

    private ArBranchRepository repository;

    public Iterable<ArBranch> findAll() {
        return repository.findAll();
    }

    public Page<ArBranch> findAll(Pageable pageable) {
        return new Page<ArBranch>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public ArBranch save(ArBranch arBranch) {
        return repository.save(arBranch);
    }

    public ArBranch findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public ArBranch findByCode(String code) {
        return repository.findByCode(code);
    }
}
