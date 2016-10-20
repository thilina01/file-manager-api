/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.jsonView;

/**
 *
 * @author Daminda
 */
public class RunDateView {

    public static interface Id {
    }

    public static interface Duration {
    }

    public static interface Quantity {
    }

    public static interface Repaired {
    }

    public static interface Rework {
    }

    public static interface RunDate {
    }

    public static interface Scrap {
    }

    public static interface Shift {
    }
    public static interface All extends Id,Duration,Quantity,Repaired,Rework,RunDate,Scrap,Shift{
        
    }

}
