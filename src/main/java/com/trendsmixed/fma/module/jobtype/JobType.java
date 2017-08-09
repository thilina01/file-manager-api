/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.jobtype;

import com.trendsmixed.fma.module.job.Job;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.jobtype.JobTypeView;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@Table(name = "job_type", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@NamedQueries({
    @NamedQuery(name = "JobType.findAll", query = "SELECT j FROM JobType j")})
public class JobType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(JobTypeView.Id.class)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JsonView(JobTypeView.Code.class)
    @Column(name = "code", length = 50)
    private String code;
    @JsonView(JobTypeView.Name.class)
    @Column(name = "name", length = 250)
    private String name;
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "jobType")
    private List<Job> jobList;

    public JobType() {
    }

    public JobType(Integer id) {
        this.id = id;
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
        if (!(object instanceof JobType)) {
            return false;
        }
        JobType other = (JobType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.JobType[ id=" + id + " ]";
    }

}
