package com.trendsmixed.fma.module.absenteeism;

import com.trendsmixed.fma.module.labourtursource.LabourSourceView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class AbsenteeismView {

    public interface Id {
    }

    public interface EffectiveMonth {
    }

    public interface Absenteeism {
    }

    public interface Target {
    }

    public interface LabourSource extends LabourSourceView.All {
    }

    public interface All extends Id, EffectiveMonth, Absenteeism, Target, PageView.All {
    }

    public interface AllAndLabourSource extends All, LabourSource {
    }
}
