package com.trendsmixed.fma.module.manpower;

import com.trendsmixed.fma.module.production.Production;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ManpowerRepository extends PagingAndSortingRepository<Manpower, Integer> {

    List<Manpower> findByProduction(Production production);

}
