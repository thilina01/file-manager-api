package com.trendsmixed.fma.module.contacttype;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactTypeRepository extends PagingAndSortingRepository<ContactType, Integer> {

    ContactType findByCode(String code);

    ContactType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM ContactType o")
    List<Combo> getCombo();

}
