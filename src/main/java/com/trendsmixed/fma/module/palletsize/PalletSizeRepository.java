package com.trendsmixed.fma.module.palletsize;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;
import com.trendsmixed.fma.dao.Combo;

public interface PalletSizeRepository extends PagingAndSortingRepository<PalletSize, Integer> {

    @Query(value = "SELECT" + " new com.trendsmixed.fma.dao.Combo(o.id, o.code, o.name)" + " FROM PalletSize o")

    List<Combo> getCombo();
}