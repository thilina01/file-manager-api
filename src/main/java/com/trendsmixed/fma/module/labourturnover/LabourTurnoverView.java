package com.trendsmixed.fma.module.labourturnover;

import com.trendsmixed.fma.module.labourtursource.LabourSourceView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class LabourTurnoverView {

    public interface Id {
    }

    public interface EffectiveMonth {
    }

    public interface Turnover {
    }

    public interface Target {
    }

    public interface LabourSource extends LabourSourceView.All {
    }

    public interface All extends Id, EffectiveMonth, Turnover, Target, PageView.All {
    }

    public interface AllAndLabourSource extends All, LabourSource {
    }
}
