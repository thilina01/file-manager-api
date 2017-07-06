package com.trendsmixed.fma.dao.view;

import com.trendsmixed.fma.module.operationtype.OperationTypeView;
import com.trendsmixed.fma.module.producttype.ProductTypeView;

public class OperationSummaryView {

    public static interface ProductType extends ProductTypeView.All {
    }

    public static interface OperationType extends OperationTypeView.All {
    }

    public static interface Quantity {
    }

    public static interface All extends ProductType, OperationType, Quantity {
    }

}
