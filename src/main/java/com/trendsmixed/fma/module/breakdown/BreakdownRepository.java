package com.trendsmixed.fma.module.breakdown;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Date;
import com.trendsmixed.fma.module.machine.Machine;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BreakdownRepository extends PagingAndSortingRepository<Breakdown, Integer> {

    Page<Breakdown> findByBreakdownTimeBetween(Date startDate, Date endDate, Pageable pageable);

    Page<Breakdown> findByBreakdownTimeBetweenAndMachine(Date startDate, Date endDate, Machine machine,
            Pageable pageable);

    Page<Breakdown> findByBreakdownTimeAndMachine(Date date, Machine machine, Pageable pageable);

    Page<Breakdown> findByMachine(Machine machine, Pageable pageable);
}
