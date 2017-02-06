/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.ControlPointPlanView;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "control_point_plan")
@NamedQueries({
    @NamedQuery(name = "ControlPointPlan.findAll", query = "SELECT c FROM ControlPointPlan c")})
public class ControlPointPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ControlPointPlanView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ControlPointPlanView.PlanDate.class)
    @Column(name = "plan_date")
    @Temporal(TemporalType.DATE)
    private Date planDate;    
    @JsonView(ControlPointPlanView.Duration.class)
    @Column(name = "duration")
    private Integer duration;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "controlPointPlan")
    private List<ControlPointPlanManpower> controlPointPlanManpowerList;
    @JsonView(ControlPointPlanView.ControlPoint.class)
    @JoinColumn(name = "control_point_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ControlPoint controlPoint;
    @JsonView(ControlPointPlanView.Shift.class)
    @JoinColumn(name = "shift_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Shift shift;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "controlPointPlan")
    private List<ControlPointPlanJob> controlPointPlanJobList;

    public ControlPointPlan() {
    }

    public ControlPointPlan(Integer id) {
        this.id = id;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ControlPointPlanManpower> getControlPointPlanManpowerList() {
        return controlPointPlanManpowerList;
    }

    public void setControlPointPlanManpowerList(List<ControlPointPlanManpower> controlPointPlanManpowerList) {
        this.controlPointPlanManpowerList = controlPointPlanManpowerList;
    }

    public ControlPoint getControlPoint() {
        return controlPoint;
    }

    public void setControlPoint(ControlPoint controlPoint) {
        this.controlPoint = controlPoint;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public List<ControlPointPlanJob> getControlPointPlanJobList() {
        return controlPointPlanJobList;
    }

    public void setControlPointPlanJobList(List<ControlPointPlanJob> controlPointPlanJobList) {
        this.controlPointPlanJobList = controlPointPlanJobList;
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
        if (!(object instanceof ControlPointPlan)) {
            return false;
        }
        ControlPointPlan other = (ControlPointPlan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.ControlPointPlan[ id=" + id + " ]";
    }

    /**
     * @return the duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }    
}
