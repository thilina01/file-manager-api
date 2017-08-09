package com.trendsmixed.fma.module.sectiontype;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionTypeRepository extends JpaRepository<SectionType, Integer> {

    public SectionType findByCode(String code);

}
