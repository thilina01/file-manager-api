/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.manpower;

/**
 *
 * @author Thilina
 */
public class ManpowerView {

    public static interface Id {
    }

    public static interface PlannedQuantity {
    }

    public static interface ActualQuantity {
    }

    public static interface ManpowerType {
    }

    public static interface Production {
    }

    public static interface All extends Id, PlannedQuantity, ActualQuantity {
    }

}
