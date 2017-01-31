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
public class ControlPointPlanManpowerView {

    public static interface Id {
    }

    public static interface Count {
    }

    public static interface ControlPointPlan {
    }

    public static interface ManpowerType {
    }

    public static interface All extends Id, Count {
    }

    public static interface AllAndManpowerTypeAllAndControlPointPlanAllAndControlPointAllAndShiftAll extends All, ManpowerType, ManpowerTypeView.All, ControlPointPlan, ControlPointPlanView.AllAndControlPointAllAndShiftAll {
    }
}
