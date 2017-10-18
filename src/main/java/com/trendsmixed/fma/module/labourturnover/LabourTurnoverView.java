package com.trendsmixed.fma.module.labourturnover;

import com.trendsmixed.fma.module.labourtursource.LabourSourceView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class LabourTurnoverView {

    public static interface Id {
    }

    public static interface EffectiveMonth {
    }

    public static interface Turnover {
    }

    public static interface Target {
    }

    public static interface LabourSource extends LabourSourceView.All {
    }

    public static interface All extends Id, EffectiveMonth, Turnover, Target, PageView.All {
    }

    public static interface AllAndLabourSource extends All, LabourSource {
    }
}
