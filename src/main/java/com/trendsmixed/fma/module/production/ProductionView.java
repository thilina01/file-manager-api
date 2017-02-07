/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.production;

/**
 *
 * @author Thilina
 */
public class ProductionView {

    public static interface Id {
    }

    public static interface ProductionDate {
    }

    public static interface PlannedDuration {
    }

    public static interface ActualDuration {
    }

    public static interface PlannedQuantity {
    }

    public static interface ActualQuantity {
    }

    public static interface ControlPoint {
    }

    public static interface Job {
    }

    public static interface Operation {
    }

    public static interface ProductType {
    }

    public static interface shift {
    }

    public static interface All extends Id, ProductionDate, PlannedDuration, ActualDuration, PlannedQuantity, ActualQuantity {
    }

}
