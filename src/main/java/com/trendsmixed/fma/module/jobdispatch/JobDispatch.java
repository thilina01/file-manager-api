/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.jobdispatch;

import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.dispatch.Dispatch;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.jobdispatch.JobDispatchView;
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
@Table(name = "job_dispatch")
@NamedQueries({
    @NamedQuery(name = "JobDispatch.findAll", query = "SELECT j FROM JobDispatch j")})
public class JobDispatch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @JsonView(JobDispatchView.Id.class)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity")
    @JsonView(JobDispatchView.Quantity.class)
    private Double quantity;
    @JoinColumn(name = "dispatch_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonView(JobDispatchView.Dispatch.class)
    private Dispatch dispatch;
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonView(JobDispatchView.Job.class)
    private Job job;

    public JobDispatch() {
    }

    public JobDispatch(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Dispatch getDispatch() {
        return dispatch;
    }

    public void setDispatch(Dispatch dispatch) {
        this.dispatch = dispatch;
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
        if (!(object instanceof JobDispatch)) {
            return false;
        }
        JobDispatch other = (JobDispatch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.JobDispatch[ id=" + id + " ]";
    }

}
