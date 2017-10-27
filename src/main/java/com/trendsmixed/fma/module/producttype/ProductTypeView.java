package com.trendsmixed.fma.module.producttype;

import com.trendsmixed.fma.module.operationtype.OperationTypeView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Thilina
 */
public class ProductTypeView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Description {
    }

    public interface OperationType {
    }

    public interface All extends Id, Code, Description, PageView.All {
    }

    public interface AllAndOperationTypeAll extends All, OperationType, OperationTypeView.All {
    }
}
