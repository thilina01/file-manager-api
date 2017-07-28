/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.toolbreakdown;

import com.trendsmixed.fma.module.tool.Tool;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.toolbreakdown.ToolBreakdownView;
import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "tool_breakdown")
@NamedQueries({
    @NamedQuery(name = "ToolBreakdown.findAll", query = "SELECT b FROM ToolBreakdown b")})
public class ToolBreakdown implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ToolBreakdownView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ToolBreakdownView.Date.class)
    @Column(name = "toolBreakdown_date")
    @Temporal(TemporalType.DATE)
    private Date toolBreakdownDate;
    @JsonView(ToolBreakdownView.Duration.class)
    @Column(name = "duration")
    private Integer duration;
    @JsonView(ToolBreakdownView.BreakdownTime.class)
    @Column(name = "toolBreakdown_time")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date toolBreakdownTime;
    @JsonView(ToolBreakdownView.RecoveryTime.class)
    @Column(name = "recovery_time")
    //@Temporal(TemporalType.TIME)
    private Date recoveryTime;
    @JsonView(ToolBreakdownView.BreakdownNumber.class)
    @Column(name = "toolBreakdown_number")
    private String toolBreakdownNumber;
    @JsonView(ToolBreakdownView.Description.class)
    @Column(name = "description")
    private String description;
    @JsonView(ToolBreakdownView.Tool.class)
    @JoinColumn(name = "tool_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tool tool;

    public ToolBreakdown() {
    }

    public ToolBreakdown(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBreakdownDate() {
        return toolBreakdownDate;
    }

    public void setBreakdownDate(Date toolBreakdownDate) {
        this.toolBreakdownDate = toolBreakdownDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getBreakdownNumber() {
        return toolBreakdownNumber;
    }

    public void setBreakdownNumber(String toolBreakdownNumber) {
        this.toolBreakdownNumber = toolBreakdownNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public Date getBreakdownTime() {
        return toolBreakdownTime;
    }

    public void setBreakdownTime(Date toolBreakdownTime) {
        this.toolBreakdownTime = toolBreakdownTime;
    }

    public Date getRecoveryTime() {
        return recoveryTime;
    }

    public void setRecoveryTime(Date recoveryTime) {
        this.recoveryTime = recoveryTime;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ToolBreakdown)) {
            return false;
        }
        ToolBreakdown other = (ToolBreakdown) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.Breakdown[ id=" + id + " ]";
    }

}
