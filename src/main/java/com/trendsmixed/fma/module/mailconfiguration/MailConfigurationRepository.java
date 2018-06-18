package com.trendsmixed.fma.module.mailconfiguration;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MailConfigurationRepository extends PagingAndSortingRepository<MailConfiguration, Integer> {

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.port,o.user )"
            + " FROM MailConfiguration o")
    List<Combo> getCombo();
}
