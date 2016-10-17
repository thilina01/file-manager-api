/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "plan_date_has_manpower_type")
@NamedQueries({
    @NamedQuery(name = "PlanDateHasManpowerType.findAll", query = "SELECT p FROM PlanDateHasManpowerType p")})
public class PlanDateHasManpowerType implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlanDateHasManpowerTypePK planDateHasManpowerTypePK;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "manpower_type_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ManpowerType manpowerType;
    @JoinColumn(name = "plan_date_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PlanDate planDate;

    public PlanDateHasManpowerType() {
    }

    public PlanDateHasManpowerType(PlanDateHasManpowerTypePK planDateHasManpowerTypePK) {
        this.planDateHasManpowerTypePK = planDateHasManpowerTypePK;
    }

    public PlanDateHasManpowerType(int manpowerTypeId, int planDateId) {
        this.planDateHasManpowerTypePK = new PlanDateHasManpowerTypePK(manpowerTypeId, planDateId);
    }

    public PlanDateHasManpowerTypePK getPlanDateHasManpowerTypePK() {
        return planDateHasManpowerTypePK;
    }

    public void setPlanDateHasManpowerTypePK(PlanDateHasManpowerTypePK planDateHasManpowerTypePK) {
        this.planDateHasManpowerTypePK = planDateHasManpowerTypePK;
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
        hash += (planDateHasManpowerTypePK != null ? planDateHasManpowerTypePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanDateHasManpowerType)) {
            return false;
        }
        PlanDateHasManpowerType other = (PlanDateHasManpowerType) object;
        if ((this.planDateHasManpowerTypePK == null && other.planDateHasManpowerTypePK != null) || (this.planDateHasManpowerTypePK != null && !this.planDateHasManpowerTypePK.equals(other.planDateHasManpowerTypePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.PlanDateHasManpowerType[ planDateHasManpowerTypePK=" + planDateHasManpowerTypePK + " ]";
    }
    
}
