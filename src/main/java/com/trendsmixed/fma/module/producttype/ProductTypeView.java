package com.trendsmixed.fma.module.producttype;

import com.trendsmixed.fma.module.operationtype.OperationTypeView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Thilina
 */
public class ProductTypeView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Description {
    }

    public static interface OperationType {
    }

    public static interface All extends Id, Code, Description, PageView.All {
    }

    public static interface AllAndOperationTypeAll extends All, OperationType, OperationTypeView.All {
    }
}
