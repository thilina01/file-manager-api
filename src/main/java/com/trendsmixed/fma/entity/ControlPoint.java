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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.controlpoint.ControlPointView;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "control_point")
@NamedQueries({ @NamedQuery(name = "ControlPoint.findAll", query = "SELECT c FROM ControlPoint c") })
public class ControlPoint implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@JsonView(ControlPointView.Id.class)
	@Column(name = "id")
	private Integer id;
	@JsonView(ControlPointView.Code.class)
	@Column(name = "code")
	private String code;
	@JsonView(ControlPointView.Name.class)
	@Column(name = "name")
	private String name;
	@JsonView(ControlPointView.WorkCenter.class)
	@JoinColumn(name = "work_center_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private WorkCenter workCenter;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "controlPoint")
	private List<Production> productionList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "controlPoint")
	private List<ControlPointMachine> controlPointMachineList;
    @JsonView(ControlPointView.ControlPointType.class)
    @JoinColumn(name = "control_point_type_id", referencedColumnName = "id")
    @ManyToOne(optional = true)    
    private ControlPointType controlPointType;
    
	public ControlPoint() {
	}

	public ControlPoint(Integer id) {
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

	public List<Production> getProductionList() {
		return productionList;
	}

	public void setProductionList(List<Production> productionList) {
		this.productionList = productionList;
	}
    

	public List<ControlPointMachine> getControlPointMachineList() {
		return controlPointMachineList;
	}

	public void setControlPointMachineList(List<ControlPointMachine> controlPointMachineList) {
		this.controlPointMachineList = controlPointMachineList;
	}

	public WorkCenter getWorkCenter() {
		return workCenter;
	}

	public void setWorkCenter(WorkCenter workCenter) {
		this.workCenter = workCenter;
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
		if (!(object instanceof ControlPoint)) {
			return false;
		}
		ControlPoint other = (ControlPoint) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.trendsmixed.fma.entity.ControlPoint[ id=" + id + " ]";
	}

}
