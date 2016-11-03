/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.ControlPointRunView;
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
@Table(name = "control_point_run")
@NamedQueries({
    @NamedQuery(name = "ControlPointRun.findAll", query = "SELECT c FROM ControlPointRun c")})
public class ControlPointRun implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ControlPointRunView.Id.class)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @JsonView(ControlPointRunView.RunDate.class)
    @Column(name = "run_date")
    @Temporal(TemporalType.DATE)
    private Date runDate;
    @JsonView(ControlPointRunView.BreakdownCount.class)
    @Column(name = "breakdown_count")
    private Integer breakdownCount;
    @JsonView(ControlPointRunView.WorkingDuration.class)
    @Column(name = "working_duration")
    private Integer workingDuration;
    @JsonView(ControlPointRunView.ControlPoint.class)
    @JoinColumn(name = "control_point_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ControlPoint controlPoint;
    @JsonView(ControlPointRunView.Shift.class)
    @JoinColumn(name = "shift_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Shift shift;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "controlPointRun")
    private List<ControlPointRunLoss> controlPointRunLossList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "controlPointRun")
    private List<ControlPointRunManpower> controlPointRunManpowerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "controlPointRun")
    private List<ControlPointRunJob> controlPointRunJobList;

    public ControlPointRun() {
    }

    public ControlPointRun(Integer id) {
        this.id = id;
    }

    public ControlPointRun(Integer id, Date runDate) {
        this.id = id;
        this.runDate = runDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }

    public Integer getBreakdownCount() {
        return breakdownCount;
    }

    public void setBreakdownCount(Integer breakdownCount) {
        this.breakdownCount = breakdownCount;
    }

    public Integer getWorkingDuration() {
        return workingDuration;
    }

    public void setWorkingDuration(Integer workingDuration) {
        this.workingDuration = workingDuration;
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

    public List<ControlPointRunLoss> getControlPointRunLossList() {
        return controlPointRunLossList;
    }

    public void setControlPointRunLossList(List<ControlPointRunLoss> controlPointRunLossList) {
        this.controlPointRunLossList = controlPointRunLossList;
    }

    public List<ControlPointRunManpower> getControlPointRunManpowerList() {
        return controlPointRunManpowerList;
    }

    public void setControlPointRunManpowerList(List<ControlPointRunManpower> controlPointRunManpowerList) {
        this.controlPointRunManpowerList = controlPointRunManpowerList;
    }

    public List<ControlPointRunJob> getControlPointRunJobList() {
        return controlPointRunJobList;
    }

    public void setControlPointRunJobList(List<ControlPointRunJob> controlPointRunJobList) {
        this.controlPointRunJobList = controlPointRunJobList;
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
        if (!(object instanceof ControlPointRun)) {
            return false;
        }
        ControlPointRun other = (ControlPointRun) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.ControlPointRun[ id=" + id + " ]";
    }

}
