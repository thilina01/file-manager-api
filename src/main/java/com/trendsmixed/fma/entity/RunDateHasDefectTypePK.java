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
public class RunDateHasDefectTypePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "defect_type_id")
    private int defectTypeId;
    @Basic(optional = false)
    @Column(name = "run_date_id")
    private int runDateId;

    public RunDateHasDefectTypePK() {
    }

    public RunDateHasDefectTypePK(int defectTypeId, int runDateId) {
        this.defectTypeId = defectTypeId;
        this.runDateId = runDateId;
    }

    public int getDefectTypeId() {
        return defectTypeId;
    }

    public void setDefectTypeId(int defectTypeId) {
        this.defectTypeId = defectTypeId;
    }

    public int getRunDateId() {
        return runDateId;
    }

    public void setRunDateId(int runDateId) {
        this.runDateId = runDateId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) defectTypeId;
        hash += (int) runDateId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RunDateHasDefectTypePK)) {
            return false;
        }
        RunDateHasDefectTypePK other = (RunDateHasDefectTypePK) object;
        if (this.defectTypeId != other.defectTypeId) {
            return false;
        }
        if (this.runDateId != other.runDateId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.RunDateHasDefectTypePK[ defectTypeId=" + defectTypeId + ", runDateId=" + runDateId + " ]";
    }
    
}
