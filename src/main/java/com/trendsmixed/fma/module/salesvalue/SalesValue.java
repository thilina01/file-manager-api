package com.trendsmixed.fma.module.salesvalue;

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
@Table(name = "sales_value")
@NamedQueries({
    @NamedQuery(name = "SalesValue.findAll", query = "SELECT c FROM SalesValue c")})
public class SalesValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(SalesValueView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(SalesValueView.EffectiveMonth.class)
    @Column(name = "effective_month")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date effectiveMonth;
    @JsonView(SalesValueView.Budget.class)
    @Column(name = "budget")
    private double budget;
    @JsonView(SalesValueView.Actual.class)
    @Column(name = "actual")
    private double actual;

}
