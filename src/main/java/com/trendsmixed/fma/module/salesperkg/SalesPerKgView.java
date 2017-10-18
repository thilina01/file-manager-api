package com.trendsmixed.fma.module.salesperkg;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class SalesPerKgView {

    public static interface Id {
    }

    public static interface EffectiveMonth {
    }

    public static interface Actual {
    }

    public static interface Budget {
    }

    public static interface All extends Id, EffectiveMonth, Actual, Budget, PageView.All {
    }

}
