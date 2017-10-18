package com.trendsmixed.fma.module.operationtype;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Thilina
 */
public class OperationTypeView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Description {
    }

    public static interface All extends Id, Description, Code, PageView.All {
    }

}
