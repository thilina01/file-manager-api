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
