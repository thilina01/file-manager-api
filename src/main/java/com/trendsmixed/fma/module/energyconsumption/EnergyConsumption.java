/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.energyconsumption;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.location.Location;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "energy_consumption")
@NamedQueries({
    @NamedQuery(name = "EnergyConsumption.findAll", query = "SELECT m FROM EnergyConsumption m")})
public class EnergyConsumption implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(EnergyConsumptionView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(EnergyConsumptionView.Kwh.class)
    @Column(name = "kwh")
    private Double kwh;
    @JsonView(EnergyConsumptionView.Kva.class)
    @Column(name = "kva")
    private Double kva;
    @JsonView(EnergyConsumptionView.Cost.class)
    @Column(name = "cost")
    private Double cost;
    @JsonView(EnergyConsumptionView.EffectiveMonth.class)
    @Column(name = "effective_month")
    private Date effectiveMonth;
    @JsonView(EnergyConsumptionView.Reference.class)
    @Column(name = "reference")
    private String reference;
    @JsonView(EnergyConsumptionView.Location.class)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Location location;

}
