/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.controlpointtype.ControlPointTypeView;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "control_point_type")
@NamedQueries({ @NamedQuery(name = "ControlPointType.findAll", query = "SELECT s FROM ControlPointType s") })
public class ControlPointType implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@JsonView(ControlPointTypeView.Id.class)
	@Column(name = "id")
	private Integer id;
	@JsonView(ControlPointTypeView.Code.class)
	@Column(name = "code")
	private String code;
	@JsonView(ControlPointTypeView.Name.class)
	@Column(name = "name")
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "controlPointType")
	private List<ControlPoint> controlPointList;

	public ControlPointType() {
	}

	public ControlPointType(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<ControlPoint> getControlPointList() {
		return controlPointList;
	}

	public void setControlPointList(List<ControlPoint> controlPointList) {
		this.controlPointList = controlPointList;
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
		if (!(object instanceof ControlPointType)) {
			return false;
		}
		ControlPointType other = (ControlPointType) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.trendsmixed.fma.entity.ControlPointType[ id=" + id + " ]";
	}

}
