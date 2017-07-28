package com.trendsmixed.fma.dao;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.view.OperationSummaryView;
import com.trendsmixed.fma.module.operationtype.OperationType;
import com.trendsmixed.fma.module.producttype.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Thilina
 */
@Data
@AllArgsConstructor
public class OperationSummary {

    @JsonView(OperationSummaryView.ProductType.class)
    private ProductType productType;
    @JsonView(OperationSummaryView.OperationType.class)
    private OperationType operationType;
    @JsonView(OperationSummaryView.Quantity.class)
    private long quantity;
}
