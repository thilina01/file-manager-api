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
public class ControlPointRunBreakdownView {

    public static interface Id {
    }

    public static interface Duration {
    }

    public static interface Reason {
    }

    public static interface BreakdownNumber {
    }

    public static interface ControlPointRun {
    }

    public static interface Machine {
    }

    public static interface All extends Id, Duration, Reason, BreakdownNumber {
    }

    public static interface AllAndControlPointRunAllAndMachineAll extends All, ControlPointRun, ControlPointRunView.All, Machine, MachineView.All {
    }

}
