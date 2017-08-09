/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.production;

import com.trendsmixed.fma.module.operation.Operation;
import com.trendsmixed.fma.module.manpower.Manpower;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.shift.Shift;
import com.trendsmixed.fma.module.shifttype.ShiftType;
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
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@Table(name = "production")
@NamedQueries({
    @NamedQuery(name = "Production.findAll", query = "SELECT p FROM Production p")})
public class Production implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(ProductionView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(ProductionView.ProductionDate.class)
    @Column(name = "production_date")
    @Temporal(TemporalType.DATE)
    private Date productionDate;
    @JsonView(ProductionView.PlannedDuration.class)
    @Column(name = "planned_duration")
    private Integer plannedDuration;
    @JsonView(ProductionView.ActualDuration.class)
    @Column(name = "actual_duration")
    private Integer actualDuration;
    @JsonView(ProductionView.ControlPoint.class)
    @JoinColumn(name = "control_point_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ControlPoint controlPoint;
    @JsonView(ProductionView.Shift.class)
    @JoinColumn(name = "shift_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Shift shift;
    @JsonView(ProductionView.ShiftType.class)
    @JoinColumn(name = "shift_type_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private ShiftType shiftType;
    @JsonView(ProductionView.Manpower.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "production")
    private List<Manpower> manpowerList;
    @JsonView(ProductionView.Operation.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "production")
    private List<Operation> operationList;

}
