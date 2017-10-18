package com.trendsmixed.fma.module.salesvalue;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class SalesValueView {

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
