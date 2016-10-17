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
@Table(name = "run_date_has_defect_type")
@NamedQueries({
    @NamedQuery(name = "RunDateHasDefectType.findAll", query = "SELECT r FROM RunDateHasDefectType r")})
public class RunDateHasDefectType implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RunDateHasDefectTypePK runDateHasDefectTypePK;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "defect_type_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DefectType defectType;
    @JoinColumn(name = "run_date_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RunDate runDate;

    public RunDateHasDefectType() {
    }

    public RunDateHasDefectType(RunDateHasDefectTypePK runDateHasDefectTypePK) {
        this.runDateHasDefectTypePK = runDateHasDefectTypePK;
    }

    public RunDateHasDefectType(int defectTypeId, int runDateId) {
        this.runDateHasDefectTypePK = new RunDateHasDefectTypePK(defectTypeId, runDateId);
    }

    public RunDateHasDefectTypePK getRunDateHasDefectTypePK() {
        return runDateHasDefectTypePK;
    }

    public void setRunDateHasDefectTypePK(RunDateHasDefectTypePK runDateHasDefectTypePK) {
        this.runDateHasDefectTypePK = runDateHasDefectTypePK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public DefectType getDefectType() {
        return defectType;
    }

    public void setDefectType(DefectType defectType) {
        this.defectType = defectType;
    }

    public RunDate getRunDate() {
        return runDate;
    }

    public void setRunDate(RunDate runDate) {
        this.runDate = runDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (runDateHasDefectTypePK != null ? runDateHasDefectTypePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RunDateHasDefectType)) {
            return false;
        }
        RunDateHasDefectType other = (RunDateHasDefectType) object;
        if ((this.runDateHasDefectTypePK == null && other.runDateHasDefectTypePK != null) || (this.runDateHasDefectTypePK != null && !this.runDateHasDefectTypePK.equals(other.runDateHasDefectTypePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.RunDateHasDefectType[ runDateHasDefectTypePK=" + runDateHasDefectTypePK + " ]";
    }
    
}
