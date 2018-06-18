package com.trendsmixed.fma.module.notifyparty;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface NotifyPartyRepository extends PagingAndSortingRepository<NotifyParty, Integer> {

    NotifyParty findByCode(String code);

    NotifyParty findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM NotifyParty o")
    List<Combo> getCombo();
}
