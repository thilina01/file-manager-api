package com.trendsmixed.fma.module.manpower;

import com.trendsmixed.fma.module.production.Production;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ManpowerRepository extends PagingAndSortingRepository<Manpower, Integer> {

    List<Manpower> findByProduction(Production production);

}
