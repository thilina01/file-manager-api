/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "job_has_control_point")
@NamedQueries({
    @NamedQuery(name = "JobHasControlPoint.findAll", query = "SELECT j FROM JobHasControlPoint j")})
public class JobHasControlPoint implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JobHasControlPointPK jobHasControlPointPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobHasControlPoint")
    private Collection<PlanDate> planDateCollection;
    @JoinColumn(name = "control_point_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ControlPoint controlPoint;
    @JoinColumn(name = "job_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Job job;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobHasControlPoint")
    private Collection<RunDate> runDateCollection;

    public JobHasControlPoint() {
    }

    public JobHasControlPoint(JobHasControlPointPK jobHasControlPointPK) {
        this.jobHasControlPointPK = jobHasControlPointPK;
    }

    public JobHasControlPoint(int jobId, int controlPointId) {
        this.jobHasControlPointPK = new JobHasControlPointPK(jobId, controlPointId);
    }

    public JobHasControlPointPK getJobHasControlPointPK() {
        return jobHasControlPointPK;
    }

    public void setJobHasControlPointPK(JobHasControlPointPK jobHasControlPointPK) {
        this.jobHasControlPointPK = jobHasControlPointPK;
    }

    public Collection<PlanDate> getPlanDateCollection() {
        return planDateCollection;
    }

    public void setPlanDateCollection(Collection<PlanDate> planDateCollection) {
        this.planDateCollection = planDateCollection;
    }

    public ControlPoint getControlPoint() {
        return controlPoint;
    }

    public void setControlPoint(ControlPoint controlPoint) {
        this.controlPoint = controlPoint;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Collection<RunDate> getRunDateCollection() {
        return runDateCollection;
    }

    public void setRunDateCollection(Collection<RunDate> runDateCollection) {
        this.runDateCollection = runDateCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobHasControlPointPK != null ? jobHasControlPointPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobHasControlPoint)) {
            return false;
        }
        JobHasControlPoint other = (JobHasControlPoint) object;
        if ((this.jobHasControlPointPK == null && other.jobHasControlPointPK != null) || (this.jobHasControlPointPK != null && !this.jobHasControlPointPK.equals(other.jobHasControlPointPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.JobHasControlPoint[ jobHasControlPointPK=" + jobHasControlPointPK + " ]";
    }
    
}
