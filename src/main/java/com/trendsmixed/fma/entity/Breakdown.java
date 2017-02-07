/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.breakdown.BreakdownView;
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
@Table(name = "breakdown")
@NamedQueries({
    @NamedQuery(name = "Breakdown.findAll", query = "SELECT b FROM Breakdown b")})
public class Breakdown implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(BreakdownView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(BreakdownView.Date.class)
    @Column(name = "breakdown_date")
    @Temporal(TemporalType.DATE)
    private Date breakdownDate;
    @JsonView(BreakdownView.Duration.class)
    @Column(name = "duration")
    private Integer duration;
    @JsonView(BreakdownView.BreakdownNumber.class)
    @Column(name = "breakdown_number")
    private String breakdownNumber;
    @JsonView(BreakdownView.Description.class)
    @Column(name = "description")
    private String description;
    @JsonView(BreakdownView.Machine.class)
    @JoinColumn(name = "machine_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Machine machine;

    public Breakdown() {
    }

    public Breakdown(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBreakdownDate() {
        return breakdownDate;
    }

    public void setBreakdownDate(Date breakdownDate) {
        this.breakdownDate = breakdownDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getBreakdownNumber() {
        return breakdownNumber;
    }

    public void setBreakdownNumber(String breakdownNumber) {
        this.breakdownNumber = breakdownNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Breakdown)) {
            return false;
        }
        Breakdown other = (Breakdown) object;
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
