/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.scrapcostperkg.ScrapCostPerKgView;
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
@Table(name = "scrap_cost_per_kg")
@NamedQueries({
    @NamedQuery(name = "ScrapCostPerKg.findAll", query = "SELECT c FROM ScrapCostPerKg c")})
public class ScrapCostPerKg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ScrapCostPerKgView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ScrapCostPerKgView.EffectiveMonth.class)
    @Column(name = "effective_month")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date effectiveMonth;
    @JsonView(ScrapCostPerKgView.Budget.class)
    @Column(name = "budget")
    private double budget;
    @JsonView(ScrapCostPerKgView.Actual.class)
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
        if (!(object instanceof ScrapCostPerKg)) {
            return false;
        }
        ScrapCostPerKg other = (ScrapCostPerKg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.ScrapCostPerKg[ id=" + id + " ]";
    }

}
