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
public class ControlPointRunJobView {

    public static interface Id {
    }

    public static interface Quantity {
    }

    public static interface ControlPointRun {
    }

    public static interface Job {
    }
    
    public static interface AllAndJobAndControlPointRun extends Id,Quantity,ControlPointRun,Job,ControlPointRunView.AllAndShiftAndControllPoint,JobView.All{
    }
    
    
}
