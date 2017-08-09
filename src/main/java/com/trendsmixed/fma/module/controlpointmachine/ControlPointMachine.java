/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.controlpointmachine;

import com.trendsmixed.fma.module.controlpoint.ControlPoint;
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
import com.trendsmixed.fma.module.machine.Machine;
import lombok.Data;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@Table(name = "control_point_machine")
@NamedQueries({
    @NamedQuery(name = "ControlPointMachine.findAll", query = "SELECT m FROM ControlPointMachine m")})
public class ControlPointMachine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ControlPointMachineView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ControlPointMachineView.ControlPoint.class)
    @JoinColumn(name = "control_point_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ControlPoint controlPoint;
    @JsonView(ControlPointMachineView.Machine.class)
    @JoinColumn(name = "machine_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Machine machine;

    public ControlPointMachine() {
    }

    public ControlPointMachine(Integer id) {
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
        if (!(object instanceof ControlPointMachine)) {
            return false;
        }
        ControlPointMachine other = (ControlPointMachine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.Machine[ id=" + id + " ]";
    }

}
