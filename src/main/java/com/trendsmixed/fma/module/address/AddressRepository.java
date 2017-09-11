package com.trendsmixed.fma.module.address;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends PagingAndSortingRepository<Address, Integer> {

    public Address findByCode(String code);

    public Address findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id,o.line1,o.addressType.name)"
            + " FROM Address o")
    public List<Combo> getCombo();
}
