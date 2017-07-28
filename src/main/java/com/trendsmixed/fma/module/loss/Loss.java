/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.loss;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.lossreason.LossReason;
import com.trendsmixed.fma.module.operation.Operation;
import com.trendsmixed.fma.module.loss.LossView;
import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "loss", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"loss_reason_id", "operation_id"})})
@NamedQueries({
    @NamedQuery(name = "Loss.findAll", query = "SELECT l FROM Loss l")})
public class Loss implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(LossView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(LossView.Quantity.class)
    @Column(name = "quantity")
    private Integer quantity;
    @JsonView(LossView.LossReason.class)
    @JoinColumn(name = "loss_reason_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LossReason lossReason;
    @JsonView(LossView.Operation.class)
    @JoinColumn(name = "operation_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    private Operation operation;

    public Loss() {
    }

    public Loss(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LossReason getLossReason() {
        return lossReason;
    }

    public void setLossReason(LossReason lossReason) {
        this.lossReason = lossReason;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
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
        if (!(object instanceof Loss)) {
            return false;
        }
        Loss other = (Loss) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.Loss[ id=" + id + " ]";
    }
    
}
