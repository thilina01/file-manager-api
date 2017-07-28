/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.workcenter;

import com.trendsmixed.fma.module.costcenter.CostCenter;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.workcenter.WorkCenterView;
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
@Table(name = "work_center")
@NamedQueries({
    @NamedQuery(name = "WorkCenter.findAll", query = "SELECT w FROM WorkCenter w")})
public class WorkCenter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(WorkCenterView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(WorkCenterView.Code.class)
    @Column(name = "code")
    private String code;
    @JsonView(WorkCenterView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workCenter")
    private List<ControlPoint> controlPointList;
    @JsonView(WorkCenterView.CostCenter.class)
    @JoinColumn(name = "cost_center_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CostCenter costCenter;

    public WorkCenter() {
    }

    public WorkCenter(Integer id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ControlPoint> getControlPointList() {
        return controlPointList;
    }

    public void setControlPointList(List<ControlPoint> controlPointList) {
        this.controlPointList = controlPointList;
    }

    public CostCenter getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
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
        if (!(object instanceof WorkCenter)) {
            return false;
        }
        WorkCenter other = (WorkCenter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.WorkCenter[ id=" + id + " ]";
    }
    
}