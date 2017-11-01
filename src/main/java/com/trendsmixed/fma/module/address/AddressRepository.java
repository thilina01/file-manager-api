package com.trendsmixed.fma.module.address;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends PagingAndSortingRepository<Address, Integer> {

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id,o.line1,o.addressType.name)"
            + " FROM Address o")
    List<Combo> getCombo();

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id,o.line1,o.addressType.name)"
            + " FROM Address o"
            + " WHERE o.customer = :customer")
    List<Combo> getComboByCustomer(@Param("customer") Customer customer);
}
