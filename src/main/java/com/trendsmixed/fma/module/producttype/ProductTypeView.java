/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
