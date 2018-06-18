package com.trendsmixed.fma.module.addresstype;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AddressTypeRepository extends PagingAndSortingRepository<AddressType, Integer> {

    AddressType findByCode(String code);

    AddressType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM AddressType o")
    List<Combo> getCombo();

}
