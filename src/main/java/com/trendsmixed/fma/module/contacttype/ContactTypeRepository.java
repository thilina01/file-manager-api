package com.trendsmixed.fma.module.contacttype;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactTypeRepository extends PagingAndSortingRepository<ContactType, Integer> {

    public ContactType findByCode(String code);

    public ContactType findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)"
            + " FROM ContactType o")
    public List<Combo> getCombo();

}
