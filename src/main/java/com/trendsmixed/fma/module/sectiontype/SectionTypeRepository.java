package com.trendsmixed.fma.module.sectiontype;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trendsmixed.fma.entity.SectionType;

public interface SectionTypeRepository extends JpaRepository<SectionType, Integer> {

    public SectionType findByCode(String code);

}
