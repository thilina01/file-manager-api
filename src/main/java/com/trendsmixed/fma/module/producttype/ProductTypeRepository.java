package com.trendsmixed.fma.module.producttype;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductTypeRepository extends PagingAndSortingRepository<ProductType,Integer>  {

    public ProductType findByCode(String code);

    @Query(value = "SELECT"
            + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.description)"
            + " FROM Item o")
    public List<Combo> getCombo();

}
