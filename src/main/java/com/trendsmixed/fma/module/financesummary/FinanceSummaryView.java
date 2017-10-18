package com.trendsmixed.fma.module.financesummary;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class FinanceSummaryView {

    public static interface Id {
    }

    public static interface EffectiveMonth {
    }

    public static interface ActualRevenue {
    }

    public static interface BudgetRevenue {
    }

    public static interface ActualGrossProfit {
    }

    public static interface BudgetGrossProfit {
    }

    public static interface ActualNetProfit {
    }

    public static interface BudgetNetProfit {
    }

    public static interface ActualEbitda {
    }

    public static interface BudgetEbitda {
    }

    public static interface All extends Id, EffectiveMonth, ActualRevenue, BudgetRevenue, ActualGrossProfit, BudgetGrossProfit, ActualNetProfit, BudgetNetProfit, ActualEbitda, BudgetEbitda, PageView.All {
    }

}
