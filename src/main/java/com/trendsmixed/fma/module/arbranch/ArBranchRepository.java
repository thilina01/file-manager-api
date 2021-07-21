package com.trendsmixed.fma.module.arbranch;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ArBranchRepository extends PagingAndSortingRepository<ArBranch, Integer> {

    ArBranch findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM ArBranch o")
    List<Combo> getCombo();
}
