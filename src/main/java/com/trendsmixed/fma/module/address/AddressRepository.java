package com.trendsmixed.fma.module.address;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends PagingAndSortingRepository<Address, Integer> {

    public Address findByCode(String code);

    public Address findByName(String name);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id,o.line1,o.addressType.name)"
            + " FROM Address o")
    public List<Combo> getCombo();

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id,o.line1,o.addressType.name)"
            + " FROM Address o"
            + " WHERE o.customer = :customer")
    public List<Combo> getComboByCustomer(@Param("customer") Customer customer);
}
