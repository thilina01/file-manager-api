/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "plan_date_manpower")
@NamedQueries({
    @NamedQuery(name = "PlanDateManpower.findAll", query = "SELECT p FROM PlanDateManpower p")})
public class PlanDateManpower implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "manpower_type_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private ManpowerType manpowerType;
    @JoinColumn(name = "plan_date_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private PlanDate planDate;

    public PlanDateManpower() {
    }

    public PlanDateManpower(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ManpowerType getManpowerType() {
        return manpowerType;
    }

    public void setManpowerType(ManpowerType manpowerType) {
        this.manpowerType = manpowerType;
    }

    public PlanDate getPlanDate() {
        return planDate;
    }

    public void setPlanDate(PlanDate planDate) {
        this.planDate = planDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanDateManpower)) {
            return false;
        }
        PlanDateManpower other = (PlanDateManpower) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.PlanDateManpower[ id=" + id + " ]";
    }
    
}
