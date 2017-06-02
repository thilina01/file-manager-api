/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.absenteeism;

import com.trendsmixed.fma.module.labourtursource.LabourSourceView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class AbsenteeismView {

    public static interface Id {
    }
    public static interface EffectiveMonth {
    }

    public static interface Absenteeism {
    }

    public static interface Target {
    }

    public static interface LabourSource extends LabourSourceView.All {
    }

    public static interface All extends Id, EffectiveMonth, Absenteeism, Target, PageView.All {
    }

    public static interface AllAndLabourSource extends All, LabourSource {
    }
}
