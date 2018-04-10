package com.trendsmixed.fma.module.packagingspecification;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.trendsmixed.fma.dao.Combo;

public interface PackagingSpecificationRepository extends PagingAndSortingRepository<PackagingSpecification, Integer> {

        @Query(value = "SELECT"
                        + " new com.trendsmixed.fma.dao.Combo(o.id, (o.palletSize.name), CONCAT(o.perPalletQuantity,'') )"
                        + " FROM PackagingSpecification o")
        List<Combo> getCombo();

        @Query(value = "SELECT"
                        + " new com.trendsmixed.fma.dao.Combo(o.id, (o.palletSize.name), CONCAT(o.perPalletQuantity,'') )"
                        + " FROM PackagingSpecification o" + " WHERE o.item.id = :id")
        List<Combo> getComboByItemId(@Param("id") int id);

}
