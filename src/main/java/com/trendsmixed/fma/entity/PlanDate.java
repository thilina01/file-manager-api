/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.PlanDateView;
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
@Table(name = "plan_date")
@NamedQueries({
    @NamedQuery(name = "PlanDate.findAll", query = "SELECT p FROM PlanDate p")})
public class PlanDate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(PlanDateView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(PlanDateView.PlanDate.class)
    @Column(name = "plan_date")
    @Temporal(TemporalType.DATE)
    private Date planDate;
    @JsonView(PlanDateView.Quantity.class)
    @Column(name = "quantity")
    private Integer quantity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planDate")
    private List<PlanDateManpower> planDateManpowerList;
    @JoinColumn(name = "job_control_point_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private JobControlPoint jobControlPoint;
    @JoinColumn(name = "shift_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Shift shift;

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

    public List<PlanDateManpower> getPlanDateManpowerList() {
        return planDateManpowerList;
    }

    public void setPlanDateManpowerList(List<PlanDateManpower> planDateManpowerList) {
        this.planDateManpowerList = planDateManpowerList;
    }

    public JobControlPoint getJobControlPoint() {
        return jobControlPoint;
    }

    public void setJobControlPoint(JobControlPoint jobControlPoint) {
        this.jobControlPoint = jobControlPoint;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
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
