package com.trendsmixed.fma.module.salesperkg;

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
@Table(name = "sales_per_kg")
public class SalesPerKg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(SalesPerKgView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(SalesPerKgView.EffectiveMonth.class)
    @Column(name = "effective_month")
    private Date effectiveMonth;
    @JsonView(SalesPerKgView.Budget.class)
    @Column(name = "budget")
    private double budget;
    @JsonView(SalesPerKgView.Actual.class)
    @Column(name = "actual")
    private double actual;

}
