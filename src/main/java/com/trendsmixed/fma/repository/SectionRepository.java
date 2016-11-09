package com.trendsmixed.fma.repository;

import com.trendsmixed.fma.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Integer> {

    public Section findByCode(String code);

}
