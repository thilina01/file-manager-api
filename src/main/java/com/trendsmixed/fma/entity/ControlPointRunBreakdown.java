/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.ControlPointRunBreakdownView;
import com.trendsmixed.fma.jsonView.ControlPointRunView;
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
@Table(name = "control_point_run_breakdown")
@NamedQueries({
    @NamedQuery(name = "ControlPointRunBreakdown.findAll", query = "SELECT c FROM ControlPointRunBreakdown c")})
public class ControlPointRunBreakdown implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ControlPointRunBreakdownView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ControlPointRunBreakdownView.Duration.class)
    @Column(name = "duration")
    private Integer duration;
    @JsonView(ControlPointRunBreakdownView.Reason.class)
    @Column(name = "reason")
    private String reason;
    @JsonView(ControlPointRunBreakdownView.BreakdownNumber.class)
    @Column(name = "breakdown_number")
    private String breakdownNumber;
    @JoinColumn(name = "control_point_run_id", referencedColumnName = "id")
    @JsonView(ControlPointRunBreakdownView.ControlPointRun.class)
    @ManyToOne(optional = false)
    private ControlPointRun controlPointRun;
    @JsonView(ControlPointRunBreakdownView.Machine.class)
    @JoinColumn(name = "machine_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Machine machine;

    public ControlPointRunBreakdown() {
    }

    public ControlPointRunBreakdown(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getBreakdownNumber() {
        return breakdownNumber;
    }

    public void setBreakdownNumber(String breakdownNumber) {
        this.breakdownNumber = breakdownNumber;
    }

    public ControlPointRun getControlPointRun() {
        return controlPointRun;
    }

    public void setControlPointRun(ControlPointRun controlPointRun) {
        this.controlPointRun = controlPointRun;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
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
        if (!(object instanceof ControlPointRunBreakdown)) {
            return false;
        }
        ControlPointRunBreakdown other = (ControlPointRunBreakdown) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.ControlPointRunBreakdown[ id=" + id + " ]";
    }

}
