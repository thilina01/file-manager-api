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
public class MachineRunningTimeView {

    public static interface Id {
    }

    public static interface Date {
    }

    public static interface Duration {
    }

    public static interface Machine {

    }
    public static interface All extends Id,Date,Duration {
        
    }
    public static interface AllAndMachineAll extends All,Machine,MachineView.All {
        
    }

}
