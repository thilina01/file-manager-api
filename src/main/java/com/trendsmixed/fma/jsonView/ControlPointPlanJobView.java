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
public class ControlPointPlanJobView {

    public static interface Id {
    }

    public static interface Quantity {
    }

    public static interface ControlPointPlan {
    }

    public static interface Job {
    }

    public static interface JobType {
    }

    public static interface All extends Id, Quantity {
    }

    public static interface AllAndJobAllAndControlPointPlanAllAndJobTypeAll extends All, Job, JobView.All, JobType, JobTypeView.AlL, ControlPointPlan, ControlPointPlanView.AllAndControlPointAllAndShiftAll {
    }
}
