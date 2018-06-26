package com.trendsmixed.fma.module.packagingspecification;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.palletsize.PalletSize;

public interface PackagingSpecificationRepository extends PagingAndSortingRepository<PackagingSpecification, Integer> {

        @Query(value = "SELECT"
                        + " new com.trendsmixed.fma.dao.Combo(o.id, (o.palletSize.name), CONCAT(o.perPalletQuantity,'') )"
                        + " FROM PackagingSpecification o")
        List<Combo> getCombo();

        @Query(value = "SELECT"
                        + " new com.trendsmixed.fma.dao.Combo(o.id, (o.palletSize.name), CONCAT(o.perPalletQuantity,'') )"
                        + " FROM PackagingSpecification o" + " WHERE o.item.id = :id")
        List<Combo> getComboByItemId(@Param("id") int id);

        Page<PackagingSpecification> findByItem(Item item, Pageable pageable);

        Page<PackagingSpecification> findByPalletSize(PalletSize palletSize, Pageable pageable);

        Page<PackagingSpecification> findByItemAndPalletSize(Item item, PalletSize palletSize, Pageable pageable);

}
