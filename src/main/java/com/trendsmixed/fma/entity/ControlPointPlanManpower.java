/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.ControlPointPlanManpowerView;
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
@Table(name = "control_point_plan_manpower")
@NamedQueries({
    @NamedQuery(name = "ControlPointPlanManpower.findAll", query = "SELECT c FROM ControlPointPlanManpower c")})
public class ControlPointPlanManpower implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ControlPointPlanManpowerView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ControlPointPlanManpowerView.count.class)
    @Column(name = "count")
    private Integer count;
    @JsonView(ControlPointPlanManpowerView.ControlPointPlan.class)
    @JoinColumn(name = "control_point_plan_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ControlPointPlan controlPointPlan;
    @JsonView(ControlPointPlanManpowerView.ManpowerType.class)
    @JoinColumn(name = "manpower_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ManpowerType manpowerType;

    public ControlPointPlanManpower() {
    }

    public ControlPointPlanManpower(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ControlPointPlan getControlPointPlan() {
        return controlPointPlan;
    }

    public void setControlPointPlan(ControlPointPlan controlPointPlan) {
        this.controlPointPlan = controlPointPlan;
    }

    public ManpowerType getManpowerType() {
        return manpowerType;
    }

    public void setManpowerType(ManpowerType manpowerType) {
        this.manpowerType = manpowerType;
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
        if (!(object instanceof ControlPointPlanManpower)) {
            return false;
        }
        ControlPointPlanManpower other = (ControlPointPlanManpower) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.ControlPointPlanManpower[ id=" + id + " ]";
    }
    
}
