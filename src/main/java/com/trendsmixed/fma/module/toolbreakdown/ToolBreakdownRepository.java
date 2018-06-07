package com.trendsmixed.fma.module.toolbreakdown;

import java.util.Date;

import com.trendsmixed.fma.module.tool.Tool;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ToolBreakdownRepository extends PagingAndSortingRepository<ToolBreakdown, Integer> {

    Page<ToolBreakdown> findByToolBreakdownTimeBetween(Date startDate, Date endDate, Pageable pageable);

    Page<ToolBreakdown> findByToolAndToolBreakdownTimeBetween(Tool tool, Date startDate, Date endDate,
            Pageable pageable);

}
