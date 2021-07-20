package com.trendsmixed.fma.module.skill;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SkillRepository extends PagingAndSortingRepository<Skill, Integer> {

    Skill findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM Skill o")
    List<Combo> getCombo();
}
