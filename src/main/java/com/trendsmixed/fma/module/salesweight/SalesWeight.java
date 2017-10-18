package com.trendsmixed.fma.module.salesweight;

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
@Table(name = "sales_weight")
@NamedQueries({
    @NamedQuery(name = "SalesWeight.findAll", query = "SELECT c FROM SalesWeight c")})
public class SalesWeight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(SalesWeightView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(SalesWeightView.EffectiveMonth.class)
    @Column(name = "effective_month")
    private Date effectiveMonth;
    @JsonView(SalesWeightView.Budget.class)
    @Column(name = "budget")
    private double budget;
    @JsonView(SalesWeightView.Actual.class)
    @Column(name = "actual")
    private double actual;

}
