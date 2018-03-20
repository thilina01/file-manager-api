package com.trendsmixed.fma.module.packagingspecification;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.trendsmixed.fma.dao.Combo;

public interface PackagingSpecificationRepository extends PagingAndSortingRepository<PackagingSpecification, Integer> {

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, '', '')" + " FROM PackagingSpecification o")
    List<Combo> getCombo();
}
