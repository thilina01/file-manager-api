package com.trendsmixed.fma.module.labourcostperkg;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class LabourCostPerKgView {

    public interface Id {
    }

    public interface EffectiveMonth {
    }

    public interface Actual {
    }

    public interface Budget {
    }

    public interface All extends Id, EffectiveMonth, Actual, Budget, PageView.All {
    }

}
