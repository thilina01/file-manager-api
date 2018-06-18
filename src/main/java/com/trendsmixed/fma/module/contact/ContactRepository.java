package com.trendsmixed.fma.module.contact;

import com.trendsmixed.fma.dao.Combo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Integer> {

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.contactNumber, o.contactType.code)"
            + " FROM Contact o")
    List<Combo> getCombo();
}
