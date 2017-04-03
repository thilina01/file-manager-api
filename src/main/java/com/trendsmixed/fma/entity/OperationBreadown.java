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

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.operationbreadown.OperationBreadownView;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "operation_breakdown")
@NamedQueries({
    @NamedQuery(name = "OperationBreadown.findAll", query = "SELECT o FROM OperationBreadown o")})
public class OperationBreadown implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(OperationBreadownView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(OperationBreadownView.Operation.class)
    @JoinColumn(name = "operation_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Operation operation;
    @JsonView(OperationBreadownView.Breakdown.class)
    @JoinColumn(name = "breakdown_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Breakdown breakdown;

    public OperationBreadown() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public Breakdown getBreakdown() {
		return breakdown;
	}

	public void setBreakdown(Breakdown breakdown) {
		this.breakdown = breakdown;
	}

	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperationBreadown)) {
            return false;
        }
        OperationBreadown other = (OperationBreadown) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.OperationBreadown[ id=" + id + " ]";
    }
    
}
