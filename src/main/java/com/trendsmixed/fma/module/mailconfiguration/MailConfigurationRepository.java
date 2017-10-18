package com.trendsmixed.fma.module.mailconfiguration;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface MailConfigurationRepository extends PagingAndSortingRepository<MailConfiguration, Integer> {

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.port,o.user )"
            + " FROM MailConfiguration o")
    public List<Combo> getCombo();
}
