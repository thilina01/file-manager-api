package com.trendsmixed.fma.module.financesummary;

import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "finance_summary")
public class FinanceSummary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(FinanceSummaryView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(FinanceSummaryView.EffectiveMonth.class)
    @Column(name = "effective_month")
    private Date effectiveMonth;
    @JsonView(FinanceSummaryView.ActualRevenue.class)
    @Column(name = "actual_revenue")
    private double actualRevenue;
    @JsonView(FinanceSummaryView.BudgetRevenue.class)
    @Column(name = "budget_revenue")
    private double budgetRevenue;
    @JsonView(FinanceSummaryView.ActualGrossProfit.class)
    @Column(name = "actual_gross_profit")
    private double actualGrossProfit;
    @JsonView(FinanceSummaryView.BudgetGrossProfit.class)
    @Column(name = "budget_gross_profit")
    private double budgetGrossProfit;
    @JsonView(FinanceSummaryView.ActualNetProfit.class)
    @Column(name = "actual_net_profit")
    private double actualNetProfit;
    @JsonView(FinanceSummaryView.BudgetNetProfit.class)
    @Column(name = "budget_net_profit")
    private double budgetNetProfit;
    @JsonView(FinanceSummaryView.ActualEbitda.class)
    @Column(name = "actual_ebitda")
    private double actualEbitda;
    @JsonView(FinanceSummaryView.BudgetEbitda.class)
    @Column(name = "budget_ebitda")
    private double budgetEbitda;

}
