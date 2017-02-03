/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.OperationView;
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

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "operation")
@NamedQueries({
    @NamedQuery(name = "Operation.findAll", query = "SELECT p FROM Operation p")})
public class Operation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(OperationView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(OperationView.Code.class)
    @Column(name = "code")
    private String code;
    @JsonView(OperationView.Description.class)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operation")
    private List<ControlPointPlanJob> controlPointPlanJobs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operation")
    private List<ControlPointRunJob> controlPointRunJobs;

    public Operation() {
    }

    public Operation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Operation)) {
            return false;
        }
        Operation other = (Operation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.Operation[ id=" + id + " ]";
    }

    /**
     * @return the controlPointPlanJobs
     */
    public List<ControlPointPlanJob> getControlPointPlanJobs() {
        return controlPointPlanJobs;
    }

    /**
     * @param controlPointPlanJobs the controlPointPlanJobs to set
     */
    public void setControlPointPlanJobs(List<ControlPointPlanJob> controlPointPlanJobs) {
        this.controlPointPlanJobs = controlPointPlanJobs;
    }

    /**
     * @return the controlPointRunJobs
     */
    public List<ControlPointRunJob> getControlPointRunJobs() {
        return controlPointRunJobs;
    }

    /**
     * @param controlPointRunJobs the controlPointRunJobs to set
     */
    public void setControlPointRunJobs(List<ControlPointRunJob> controlPointRunJobs) {
        this.controlPointRunJobs = controlPointRunJobs;
    }

}
