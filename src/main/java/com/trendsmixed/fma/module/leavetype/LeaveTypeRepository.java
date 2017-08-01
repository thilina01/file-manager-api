package com.trendsmixed.fma.module.leavetype;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LeaveTypeRepository extends PagingAndSortingRepository<LeaveType, Integer> {

    public LeaveType findByCode(String code);

    public LeaveType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM LeaveType o")
    public List<Combo> getCombo();
}
