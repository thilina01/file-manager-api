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
public class ControlPointRunLossView {

    public static interface Id {
    }

    public static interface Quantity {
    }

    public static interface ControlPointRun {
    }

    public static interface LossReason {
    }

    public static interface AllAndControlPointRunAndLossReasonAndLossType extends Id, Quantity, ControlPointRun, LossReason, ControlPointRunView.AllAndShiftAndControllPoint, LossReasonView.AllAndLossTypeAll, LossTypeView.All {
    }

}
