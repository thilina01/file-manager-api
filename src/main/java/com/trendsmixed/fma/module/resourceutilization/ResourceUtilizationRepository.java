package com.trendsmixed.fma.module.resourceutilization;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ResourceUtilizationRepository extends PagingAndSortingRepository<ResourceUtilization, Integer> {

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id,'', '')" + " FROM ResourceUtilization o")
    List<Combo> getCombo();

}
