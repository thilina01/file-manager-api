
package com.trendsmixed.fma.module.addresstype;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressTypeRepository extends PagingAndSortingRepository<AddressType,Integer> {

    public AddressType findByCode(String code);
    
    public AddressType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM AddressType o")
    public List<Combo> getCombo();

}