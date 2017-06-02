package com.trendsmixed.fma.module.absenteeism;

import com.trendsmixed.fma.module.labourturnover.*;
import com.trendsmixed.fma.entity.Absenteeism;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AbsenteeismRepository extends PagingAndSortingRepository<Absenteeism, Integer> {

}
