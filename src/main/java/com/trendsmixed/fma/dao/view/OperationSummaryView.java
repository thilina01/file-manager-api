package com.trendsmixed.fma.dao.view;

import com.trendsmixed.fma.module.operationtype.OperationTypeView;
import com.trendsmixed.fma.module.producttype.ProductTypeView;

public class OperationSummaryView {

    public  interface ProductType extends ProductTypeView.All {
    }

    public  interface OperationType extends OperationTypeView.All {
    }

    public  interface Quantity {
    }

    public  interface All extends ProductType, OperationType, Quantity {
    }

}
