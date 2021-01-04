package com.trendsmixed.fma.module.defect;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Date;

import com.trendsmixed.fma.module.section.Section;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface DefectRepository extends PagingAndSortingRepository<Defect, Integer> {

    Page<Defect> findByDefectDateBetween(Date startDate, Date endDate, Pageable pageable);

    Page<Defect> findBySectionAndDefectDateBetween(Section section, Date startDate, Date endDate, Pageable pageable);

}
