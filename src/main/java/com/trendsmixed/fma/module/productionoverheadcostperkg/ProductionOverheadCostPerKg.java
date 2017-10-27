package com.trendsmixed.fma.module.productionoverheadcostperkg;

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
public class ProductionOverheadCostPerKg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ProductionOverheadCostPerKgView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ProductionOverheadCostPerKgView.EffectiveMonth.class)
    @Column(name = "effective_month")
    private Date effectiveMonth;
    @JsonView(ProductionOverheadCostPerKgView.Budget.class)
    @Column(name = "budget")
    private double budget;
    @JsonView(ProductionOverheadCostPerKgView.Actual.class)
    @Column(name = "actual")
    private double actual;

}
