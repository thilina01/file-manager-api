package com.trendsmixed.fma.module.scrapcostperkg;

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
@Table(name = "scrap_cost_per_kg")
public class ScrapCostPerKg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ScrapCostPerKgView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ScrapCostPerKgView.EffectiveMonth.class)
    @Column(name = "effective_month")
    private Date effectiveMonth;
    @JsonView(ScrapCostPerKgView.Budget.class)
    @Column(name = "budget")
    private double budget;
    @JsonView(ScrapCostPerKgView.Actual.class)
    @Column(name = "actual")
    private double actual;

}
