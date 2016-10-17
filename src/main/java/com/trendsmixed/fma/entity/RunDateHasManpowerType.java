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
@Table(name = "run_date_has_manpower_type")
@NamedQueries({
    @NamedQuery(name = "RunDateHasManpowerType.findAll", query = "SELECT r FROM RunDateHasManpowerType r")})
public class RunDateHasManpowerType implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RunDateHasManpowerTypePK runDateHasManpowerTypePK;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "manpower_type_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ManpowerType manpowerType;
    @JoinColumn(name = "run_date_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RunDate runDate;

    public RunDateHasManpowerType() {
    }

    public RunDateHasManpowerType(RunDateHasManpowerTypePK runDateHasManpowerTypePK) {
        this.runDateHasManpowerTypePK = runDateHasManpowerTypePK;
    }

    public RunDateHasManpowerType(int runDateId, int manpowerTypeId) {
        this.runDateHasManpowerTypePK = new RunDateHasManpowerTypePK(runDateId, manpowerTypeId);
    }

    public RunDateHasManpowerTypePK getRunDateHasManpowerTypePK() {
        return runDateHasManpowerTypePK;
    }

    public void setRunDateHasManpowerTypePK(RunDateHasManpowerTypePK runDateHasManpowerTypePK) {
        this.runDateHasManpowerTypePK = runDateHasManpowerTypePK;
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

    public RunDate getRunDate() {
        return runDate;
    }

    public void setRunDate(RunDate runDate) {
        this.runDate = runDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (runDateHasManpowerTypePK != null ? runDateHasManpowerTypePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RunDateHasManpowerType)) {
            return false;
        }
        RunDateHasManpowerType other = (RunDateHasManpowerType) object;
        if ((this.runDateHasManpowerTypePK == null && other.runDateHasManpowerTypePK != null) || (this.runDateHasManpowerTypePK != null && !this.runDateHasManpowerTypePK.equals(other.runDateHasManpowerTypePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.RunDateHasManpowerType[ runDateHasManpowerTypePK=" + runDateHasManpowerTypePK + " ]";
    }
    
}
