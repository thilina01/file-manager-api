/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.controlpoint;

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
import com.trendsmixed.fma.module.controlpointmachine.ControlPointMachine;
import com.trendsmixed.fma.module.controlpointtype.ControlPointType;
import com.trendsmixed.fma.module.production.Production;
import com.trendsmixed.fma.module.workcenter.WorkCenter;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@Table(name = "control_point")
@NamedQueries({
    @NamedQuery(name = "ControlPoint.findAll", query = "SELECT c FROM ControlPoint c")})
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
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "controlPoint")
    private List<Production> productionList;
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "controlPoint")
    private List<ControlPointMachine> controlPointMachineList;
    @JsonView(ControlPointView.ControlPointType.class)
    @JoinColumn(name = "control_point_type_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private ControlPointType controlPointType;

}
