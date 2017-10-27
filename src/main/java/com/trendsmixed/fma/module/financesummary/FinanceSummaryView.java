package com.trendsmixed.fma.module.financesummary;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class FinanceSummaryView {

    public interface Id {
    }

    public interface EffectiveMonth {
    }

    public interface ActualRevenue {
    }

    public interface BudgetRevenue {
    }

    public interface ActualGrossProfit {
    }

    public interface BudgetGrossProfit {
    }

    public interface ActualNetProfit {
    }

    public interface BudgetNetProfit {
    }

    public interface ActualEbitda {
    }

    public interface BudgetEbitda {
    }

    public interface All extends Id, EffectiveMonth, ActualRevenue, BudgetRevenue, ActualGrossProfit, BudgetGrossProfit, ActualNetProfit, BudgetNetProfit, ActualEbitda, BudgetEbitda, PageView.All {
    }

}
