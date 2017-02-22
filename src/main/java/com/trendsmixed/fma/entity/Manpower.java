/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

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

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.manpower.ManpowerView;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "manpower")
@NamedQueries({ @NamedQuery(name = "Manpower.findAll", query = "SELECT m FROM Manpower m") })
public class Manpower implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonView(ManpowerView.Id.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@JsonView(ManpowerView.PlannedQuantity.class)
	@Column(name = "planned_quantity")
	private Integer plannedQuantity;
	@JsonView(ManpowerView.ActualQuantity.class)
	@Column(name = "actual_quantity")
	private Integer actualQuantity;
	@JsonView(ManpowerView.ManpowerType.class)
	@JoinColumn(name = "manpower_type_id", referencedColumnName = "id")
	@ManyToOne(optional = false, cascade = CascadeType.REMOVE)
	private ManpowerType manpowerType;
	@JsonView(ManpowerView.Production.class)
	@JoinColumn(name = "production_id", referencedColumnName = "id")
	@ManyToOne(optional = false, cascade = CascadeType.REMOVE)
	private Production production;

	public Manpower() {
	}

	public Manpower(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPlannedQuantity() {
		return plannedQuantity;
	}

	public void setPlannedQuantity(Integer plannedQuantity) {
		this.plannedQuantity = plannedQuantity;
	}

	public Integer getActualQuantity() {
		return actualQuantity;
	}

	public void setActualQuantity(Integer actualQuantity) {
		this.actualQuantity = actualQuantity;
	}

	public ManpowerType getManpowerType() {
		return manpowerType;
	}

	public void setManpowerType(ManpowerType manpowerType) {
		this.manpowerType = manpowerType;
	}

	public Production getProduction() {
		return production;
	}

	public void setProduction(Production production) {
		this.production = production;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Manpower)) {
			return false;
		}
		Manpower other = (Manpower) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.trendsmixed.fma.entity.Manpower[ id=" + id + " ]";
	}

}
