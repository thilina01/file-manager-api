package com.trendsmixed.fma.module.operationprogress;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.trendsmixed.fma.dao.Combo;

public interface OperationProgressRepository extends PagingAndSortingRepository<OperationProgress, Integer> {

}
