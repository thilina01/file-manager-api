/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.ControlPointRunJobView;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "control_point_run_job")
@NamedQueries({
    @NamedQuery(name = "ControlPointRunJob.findAll", query = "SELECT c FROM ControlPointRunJob c")})
public class ControlPointRunJob implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ControlPointRunJobView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ControlPointRunJobView.Quantity.class)
    @Column(name = "quantity")
    private Integer quantity;
    @JsonView(ControlPointRunJobView.ControlPointRun.class)
    @JoinColumn(name = "control_point_run_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ControlPointRun controlPointRun;
    @JsonView(ControlPointRunJobView.Job.class)
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Job job;
    @JsonView(ControlPointRunJobView.JobType.class)
    @JoinColumn(name = "job_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private JobType jobType;

    public ControlPointRunJob() {
    }

    public ControlPointRunJob(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ControlPointRun getControlPointRun() {
        return controlPointRun;
    }

    public void setControlPointRun(ControlPointRun controlPointRun) {
        this.controlPointRun = controlPointRun;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
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
        if (!(object instanceof ControlPointRunJob)) {
            return false;
        }
        ControlPointRunJob other = (ControlPointRunJob) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.ControlPointRunJob[ id=" + id + " ]";
    }

    /**
     * @return the jobType
     */
    public JobType getJobType() {
        return jobType;
    }

    /**
     * @param jobType the jobType to set
     */
    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

}
