package com.trendsmixed.fma.module.skill;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SkillService {

    private SkillRepository repository;

    public Iterable<Skill> findAll() {
        return repository.findAll();
    }

    public Page<Skill> findAll(Pageable pageable) {
        return new Page<Skill>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Skill save(Skill skill) {
        return repository.save(skill);
    }

    public Skill findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Skill findByCode(String code) {
        return repository.findByCode(code);
    }
}
