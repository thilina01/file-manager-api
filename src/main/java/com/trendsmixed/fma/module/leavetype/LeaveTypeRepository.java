package com.trendsmixed.fma.module.leavetype;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LeaveTypeRepository extends PagingAndSortingRepository<LeaveType, Integer> {

    LeaveType findByCode(String code);

    LeaveType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM LeaveType o")
    List<Combo> getCombo();
}
