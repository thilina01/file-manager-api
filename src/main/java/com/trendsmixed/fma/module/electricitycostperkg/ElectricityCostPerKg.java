package com.trendsmixed.fma.module.electricitycostperkg;

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
@Table(name = "electricity_cost_per_kg")
public class ElectricityCostPerKg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ElectricityCostPerKgView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ElectricityCostPerKgView.EffectiveMonth.class)
    @Column(name = "effective_month")
    private Date effectiveMonth;
    @JsonView(ElectricityCostPerKgView.Budget.class)
    @Column(name = "budget")
    private double budget;
    @JsonView(ElectricityCostPerKgView.Actual.class)
    @Column(name = "actual")
    private double actual;

}
