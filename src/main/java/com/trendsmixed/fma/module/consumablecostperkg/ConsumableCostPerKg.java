package com.trendsmixed.fma.module.consumablecostperkg;

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
@Table(name = "consumable_cost_per_kg")
public class ConsumableCostPerKg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ConsumableCostPerKgView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ConsumableCostPerKgView.EffectiveMonth.class)
    @Column(name = "effective_month")
    private Date effectiveMonth;
    @JsonView(ConsumableCostPerKgView.Budget.class)
    @Column(name = "budget")
    private double budget;
    @JsonView(ConsumableCostPerKgView.Actual.class)
    @Column(name = "actual")
    private double actual;

}
