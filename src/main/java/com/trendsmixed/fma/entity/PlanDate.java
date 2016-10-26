/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "plan_date")
@NamedQueries({
    @NamedQuery(name = "PlanDate.findAll", query = "SELECT p FROM PlanDate p")})
public class PlanDate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "plan_date")
    @Temporal(TemporalType.DATE)
    private Date planDate;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "shift")
    private String shift;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planDate")
    private PlanDateManpower planDateManpower;
    @JoinColumn(name = "job_control_point_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private JobControlPoint jobControlPoint;

    public PlanDate() {
    }

    public PlanDate(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public PlanDateManpower getPlanDateManpower() {
        return planDateManpower;
    }

    public void setPlanDateManpower(PlanDateManpower planDateManpower) {
        this.planDateManpower = planDateManpower;
    }

    public JobControlPoint getJobControlPoint() {
        return jobControlPoint;
    }

    public void setJobControlPoint(JobControlPoint jobControlPoint) {
        this.jobControlPoint = jobControlPoint;
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
        if (!(object instanceof PlanDate)) {
            return false;
        }
        PlanDate other = (PlanDate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.PlanDate[ id=" + id + " ]";
    }
    
}
