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
public class RunDateHasScrapTypePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "run_date_id")
    private int runDateId;
    @Basic(optional = false)
    @Column(name = "scrap_type_id")
    private int scrapTypeId;

    public RunDateHasScrapTypePK() {
    }

    public RunDateHasScrapTypePK(int runDateId, int scrapTypeId) {
        this.runDateId = runDateId;
        this.scrapTypeId = scrapTypeId;
    }

    public int getRunDateId() {
        return runDateId;
    }

    public void setRunDateId(int runDateId) {
        this.runDateId = runDateId;
    }

    public int getScrapTypeId() {
        return scrapTypeId;
    }

    public void setScrapTypeId(int scrapTypeId) {
        this.scrapTypeId = scrapTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) runDateId;
        hash += (int) scrapTypeId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RunDateHasScrapTypePK)) {
            return false;
        }
        RunDateHasScrapTypePK other = (RunDateHasScrapTypePK) object;
        if (this.runDateId != other.runDateId) {
            return false;
        }
        if (this.scrapTypeId != other.scrapTypeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.RunDateHasScrapTypePK[ runDateId=" + runDateId + ", scrapTypeId=" + scrapTypeId + " ]";
    }
    
}
