package com.trendsmixed.fma.module.cumulativesalesperkg;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class CumulativeSalesPerKgView {

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
