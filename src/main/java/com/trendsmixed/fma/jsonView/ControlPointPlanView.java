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
public class ControlPointPlanView {

    public static interface Id {
    }

    public static interface PlanDate {
    }

    public static interface ControlPoint {
    }

    public static interface Shift {
    }

    public static interface Duration {
    }

    public static interface All extends Id, PlanDate, Duration {
    }

    static interface AllAndControlPointAllAndShiftAll extends All, ControlPoint, ControlPointView.All, Shift, ShiftView.All {
    }

}
