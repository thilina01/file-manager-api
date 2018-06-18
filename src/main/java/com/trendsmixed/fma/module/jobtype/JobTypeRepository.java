package com.trendsmixed.fma.module.jobtype;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface JobTypeRepository extends PagingAndSortingRepository<JobType, Integer> {

    JobType findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM JobType o")
    List<Combo> getCombo();
}
