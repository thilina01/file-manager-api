package com.trendsmixed.fma.module.consumablecostperkg;

import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "consumable_cost_per_kg")
@NamedQueries({
    @NamedQuery(name = "ConsumableCostPerKg.findAll", query = "SELECT c FROM ConsumableCostPerKg c")})
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
