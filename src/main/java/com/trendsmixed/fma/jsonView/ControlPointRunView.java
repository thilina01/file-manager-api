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
public class ControlPointRunView {

    public static interface Id {
    }

    public static interface RunDate {
    }

    public static interface BreakdownCount {
    }

    public static interface BreakdownDuration {
    }

    public static interface WorkingDuration {
    }

    public static interface ControlPoint {
    }

    public static interface Shift {
    }

    public static interface All extends Id, RunDate, BreakdownCount, BreakdownDuration, WorkingDuration {

    }

    public static interface AllAndShiftAndControllPoint extends All, Shift, ControlPoint, ShiftView.All, ControlPointView.All {
    }

}
