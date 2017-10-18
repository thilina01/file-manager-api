package com.trendsmixed.fma.module.labourcostperkg;

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
@Table(name = "labour_cost_per_kg")
@NamedQueries({
    @NamedQuery(name = "LabourCostPerKg.findAll", query = "SELECT c FROM LabourCostPerKg c")})
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
