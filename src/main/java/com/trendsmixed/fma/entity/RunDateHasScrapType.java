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
@Table(name = "run_date_has_scrap_type")
@NamedQueries({
    @NamedQuery(name = "RunDateHasScrapType.findAll", query = "SELECT r FROM RunDateHasScrapType r")})
public class RunDateHasScrapType implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RunDateHasScrapTypePK runDateHasScrapTypePK;
    @Column(name = "quantity")
    private String quantity;
    @JoinColumn(name = "run_date_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RunDate runDate;
    @JoinColumn(name = "scrap_type_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ScrapType scrapType;

    public RunDateHasScrapType() {
    }

    public RunDateHasScrapType(RunDateHasScrapTypePK runDateHasScrapTypePK) {
        this.runDateHasScrapTypePK = runDateHasScrapTypePK;
    }

    public RunDateHasScrapType(int runDateId, int scrapTypeId) {
        this.runDateHasScrapTypePK = new RunDateHasScrapTypePK(runDateId, scrapTypeId);
    }

    public RunDateHasScrapTypePK getRunDateHasScrapTypePK() {
        return runDateHasScrapTypePK;
    }

    public void setRunDateHasScrapTypePK(RunDateHasScrapTypePK runDateHasScrapTypePK) {
        this.runDateHasScrapTypePK = runDateHasScrapTypePK;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public RunDate getRunDate() {
        return runDate;
    }

    public void setRunDate(RunDate runDate) {
        this.runDate = runDate;
    }

    public ScrapType getScrapType() {
        return scrapType;
    }

    public void setScrapType(ScrapType scrapType) {
        this.scrapType = scrapType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (runDateHasScrapTypePK != null ? runDateHasScrapTypePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RunDateHasScrapType)) {
            return false;
        }
        RunDateHasScrapType other = (RunDateHasScrapType) object;
        if ((this.runDateHasScrapTypePK == null && other.runDateHasScrapTypePK != null) || (this.runDateHasScrapTypePK != null && !this.runDateHasScrapTypePK.equals(other.runDateHasScrapTypePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.RunDateHasScrapType[ runDateHasScrapTypePK=" + runDateHasScrapTypePK + " ]";
    }
    
}
