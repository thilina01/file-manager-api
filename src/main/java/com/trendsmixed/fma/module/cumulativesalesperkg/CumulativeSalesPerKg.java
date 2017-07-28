/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.cumulativesalesperkg;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.cumulativesalesperkg.CumulativeSalesPerKgView;
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

/**
 *
 * @author Thilina
 */
@Entity
@Data
@Table(name = "cumulative_sales_per_kg")
@NamedQueries({
    @NamedQuery(name = "CumulativeSalesPerKg.findAll", query = "SELECT c FROM CumulativeSalesPerKg c")})
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
    //@Temporal(TemporalType.TIMESTAMP)
    private Date effectiveMonth;
    @JsonView(CumulativeSalesPerKgView.Budget.class)
    @Column(name = "budget")
    private double budget;
    @JsonView(CumulativeSalesPerKgView.Actual.class)
    @Column(name = "actual")
    private double actual;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CumulativeSalesPerKg)) {
            return false;
        }
        CumulativeSalesPerKg other = (CumulativeSalesPerKg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.CumulativeSalesPerKg[ id=" + id + " ]";
    }
    
}
