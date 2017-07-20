package com.trendsmixed.fma.module.notifyparty;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.NotifyParty;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NotifyPartyRepository extends PagingAndSortingRepository<NotifyParty, Integer> {

    public NotifyParty findByCode(String code);

    public NotifyParty findByName(String name);

	@Query(value = "SELECT"
			+ " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
			+ " FROM NotifyParty o")
	public List<Combo> getCombo();
}
