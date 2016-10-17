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
public class RunDateHasManpowerTypePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "run_date_id")
    private int runDateId;
    @Basic(optional = false)
    @Column(name = "manpower_type_id")
    private int manpowerTypeId;

    public RunDateHasManpowerTypePK() {
    }

    public RunDateHasManpowerTypePK(int runDateId, int manpowerTypeId) {
        this.runDateId = runDateId;
        this.manpowerTypeId = manpowerTypeId;
    }

    public int getRunDateId() {
        return runDateId;
    }

    public void setRunDateId(int runDateId) {
        this.runDateId = runDateId;
    }

    public int getManpowerTypeId() {
        return manpowerTypeId;
    }

    public void setManpowerTypeId(int manpowerTypeId) {
        this.manpowerTypeId = manpowerTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) runDateId;
        hash += (int) manpowerTypeId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RunDateHasManpowerTypePK)) {
            return false;
        }
        RunDateHasManpowerTypePK other = (RunDateHasManpowerTypePK) object;
        if (this.runDateId != other.runDateId) {
            return false;
        }
        if (this.manpowerTypeId != other.manpowerTypeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.RunDateHasManpowerTypePK[ runDateId=" + runDateId + ", manpowerTypeId=" + manpowerTypeId + " ]";
    }
    
}
