/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.operationtype;

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

    public static interface All extends Id, Code, Description {
    }

}
