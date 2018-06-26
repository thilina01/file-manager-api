package com.trendsmixed.fma.module.scrap;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Date;

import com.trendsmixed.fma.module.section.Section;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ScrapRepository extends PagingAndSortingRepository<Scrap, Integer> {

    Page<Scrap> findByScrapDateBetween(Date startDate, Date endDate, Pageable pageable);

    Page<Scrap> findBySectionAndScrapDateBetween(Section section, Date startDate, Date endDate, Pageable pageable);

}
