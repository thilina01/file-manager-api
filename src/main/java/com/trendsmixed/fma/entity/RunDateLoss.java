/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

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
@Table(name = "run_date_loss")
@NamedQueries({
    @NamedQuery(name = "RunDateLoss.findAll", query = "SELECT r FROM RunDateLoss r")})
public class RunDateLoss implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity")
    private Double quantity;
    @JoinColumn(name = "run_date_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RunDate runDate;
    @JoinColumn(name = "loss_reason_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LossReason lossReason;

    public RunDateLoss() {
    }

    public RunDateLoss(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public RunDate getRunDate() {
        return runDate;
    }

    public void setRunDate(RunDate runDate) {
        this.runDate = runDate;
    }

    public LossReason getLossReason() {
        return lossReason;
    }

    public void setLossReason(LossReason lossReason) {
        this.lossReason = lossReason;
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
        if (!(object instanceof RunDateLoss)) {
            return false;
        }
        RunDateLoss other = (RunDateLoss) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.RunDateLoss[ id=" + id + " ]";
    }
    
}
