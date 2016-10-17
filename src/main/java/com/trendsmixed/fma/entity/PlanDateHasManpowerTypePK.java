/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Thilina
 */
@Embeddable
public class PlanDateHasManpowerTypePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "manpower_type_id")
    private int manpowerTypeId;
    @Basic(optional = false)
    @Column(name = "plan_date_id")
    private int planDateId;

    public PlanDateHasManpowerTypePK() {
    }

    public PlanDateHasManpowerTypePK(int manpowerTypeId, int planDateId) {
        this.manpowerTypeId = manpowerTypeId;
        this.planDateId = planDateId;
    }

    public int getManpowerTypeId() {
        return manpowerTypeId;
    }

    public void setManpowerTypeId(int manpowerTypeId) {
        this.manpowerTypeId = manpowerTypeId;
    }

    public int getPlanDateId() {
        return planDateId;
    }

    public void setPlanDateId(int planDateId) {
        this.planDateId = planDateId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) manpowerTypeId;
        hash += (int) planDateId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanDateHasManpowerTypePK)) {
            return false;
        }
        PlanDateHasManpowerTypePK other = (PlanDateHasManpowerTypePK) object;
        if (this.manpowerTypeId != other.manpowerTypeId) {
            return false;
        }
        if (this.planDateId != other.planDateId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.PlanDateHasManpowerTypePK[ manpowerTypeId=" + manpowerTypeId + ", planDateId=" + planDateId + " ]";
    }
    
}
