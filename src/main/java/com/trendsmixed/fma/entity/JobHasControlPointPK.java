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
public class JobHasControlPointPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "job_id")
    private int jobId;
    @Basic(optional = false)
    @Column(name = "control_point_id")
    private int controlPointId;

    public JobHasControlPointPK() {
    }

    public JobHasControlPointPK(int jobId, int controlPointId) {
        this.jobId = jobId;
        this.controlPointId = controlPointId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getControlPointId() {
        return controlPointId;
    }

    public void setControlPointId(int controlPointId) {
        this.controlPointId = controlPointId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) jobId;
        hash += (int) controlPointId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobHasControlPointPK)) {
            return false;
        }
        JobHasControlPointPK other = (JobHasControlPointPK) object;
        if (this.jobId != other.jobId) {
            return false;
        }
        if (this.controlPointId != other.controlPointId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.JobHasControlPointPK[ jobId=" + jobId + ", controlPointId=" + controlPointId + " ]";
    }
    
}
