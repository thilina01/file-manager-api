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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.energyconsumption.EnergyConsumptionView;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author Thilina
 */
@Entity
@Data
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
    //@Temporal(TemporalType.TIMESTAMP)
    private Date effectiveMonth;
    @JsonView(EnergyConsumptionView.Reference.class)
    @Column(name = "reference")
    private String reference;
    @JsonView(EnergyConsumptionView.Location.class)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Location location;

    public EnergyConsumption() {
    }

    public EnergyConsumption(Integer id) {
        this.id = id;
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
        if (!(object instanceof EnergyConsumption)) {
            return false;
        }
        EnergyConsumption other = (EnergyConsumption) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.EnergyConsumption[ id=" + id + " ]";
    }

}
