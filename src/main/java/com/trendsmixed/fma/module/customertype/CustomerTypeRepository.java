package com.trendsmixed.fma.module.customertype;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.CustomerType;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerTypeRepository extends PagingAndSortingRepository<CustomerType, Integer> {

    public CustomerType findByCode(String code);

    public CustomerType findByName(String name);

	@Query(value = "SELECT"
			+ " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.type)"
			+ " FROM JobType o")
	public List<Combo> getCombo();
}
