package com.trendsmixed.fma.module.cumulativesalesperkg;

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
@Table(name = "cumulative_sales_per_kg")
public class CumulativeSalesPerKg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(CumulativeSalesPerKgView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(CumulativeSalesPerKgView.EffectiveMonth.class)
    @Column(name = "effective_month")
    private Date effectiveMonth;
    @JsonView(CumulativeSalesPerKgView.Budget.class)
    @Column(name = "budget")
    private double budget;
    @JsonView(CumulativeSalesPerKgView.Actual.class)
    @Column(name = "actual")
    private double actual;

}
