/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "job_control_point")
@NamedQueries({
    @NamedQuery(name = "JobControlPoint.findAll", query = "SELECT j FROM JobControlPoint j")})
public class JobControlPoint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobControlPoint")
    private List<PlanDate> planDateList;
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Job job;
    @JoinColumn(name = "control_point_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ControlPoint controlPoint;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobControlPoint")
    private List<RunDate> runDateList;

    public JobControlPoint() {
    }

    public JobControlPoint(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PlanDate> getPlanDateList() {
        return planDateList;
    }

    public void setPlanDateList(List<PlanDate> planDateList) {
        this.planDateList = planDateList;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public ControlPoint getControlPoint() {
        return controlPoint;
    }

    public void setControlPoint(ControlPoint controlPoint) {
        this.controlPoint = controlPoint;
    }

    public List<RunDate> getRunDateList() {
        return runDateList;
    }

    public void setRunDateList(List<RunDate> runDateList) {
        this.runDateList = runDateList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobControlPoint)) {
            return false;
        }
        JobControlPoint other = (JobControlPoint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.JobControlPoint[ id=" + id + " ]";
    }
    
}
