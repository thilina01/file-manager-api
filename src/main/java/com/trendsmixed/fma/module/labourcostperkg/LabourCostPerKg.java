package com.trendsmixed.fma.module.labourcostperkg;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "labour_cost_per_kg")
public class LabourCostPerKg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(LabourCostPerKgView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(LabourCostPerKgView.EffectiveMonth.class)
    @Column(name = "effective_month")
    private Date effectiveMonth;
    @JsonView(LabourCostPerKgView.Budget.class)
    @Column(name = "budget")
    private double budget;
    @JsonView(LabourCostPerKgView.Actual.class)
    @Column(name = "actual")
    private double actual;

}
