package com.trendsmixed.fma.module.dispatchnote;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface DispatchNoteRepository extends PagingAndSortingRepository<DispatchNote, Integer> {

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id,'','')"
            + " FROM DispatchNote o")
    List<Combo> getCombo();

    DispatchNote findById(String id);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id,'','')"
            + " FROM  DispatchNote o"
            + " WHERE o.customer = :customer")
    List<Combo> getComboByCustomer(@Param("customer") Customer customer);

}
