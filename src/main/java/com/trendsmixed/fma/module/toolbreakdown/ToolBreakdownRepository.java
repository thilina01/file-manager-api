package com.trendsmixed.fma.module.toolbreakdown;

import com.trendsmixed.fma.module.tool.Tool;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface ToolBreakdownRepository extends PagingAndSortingRepository<ToolBreakdown, Integer> {

    Page<ToolBreakdown> findByToolBreakdownTimeBetween(Date startDate, Date endDate, Pageable pageable);

    Page<ToolBreakdown> findByToolAndToolBreakdownTimeBetween(Tool tool, Date startDate, Date endDate,
            Pageable pageable);

}
