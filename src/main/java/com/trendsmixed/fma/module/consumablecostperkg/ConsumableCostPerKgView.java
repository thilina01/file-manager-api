package com.trendsmixed.fma.module.consumablecostperkg;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class ConsumableCostPerKgView {

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
