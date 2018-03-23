package com.trendsmixed.fma.module.port;

import java.util.List;

import com.trendsmixed.fma.dao.Combo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PortRepository extends PagingAndSortingRepository<Port, Integer> {

    Port findByCode(String code);

    Port findByName(String name);

    @Query(value = "SELECT" 
    + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)" 
    + " FROM Port o")
    public List<Combo> getCombo();

    List<Port> findByAddressListCustomerId(int customerId);
}
