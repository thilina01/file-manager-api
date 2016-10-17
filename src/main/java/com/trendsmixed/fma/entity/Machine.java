/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "machine")
@NamedQueries({
    @NamedQuery(name = "Machine.findAll", query = "SELECT m FROM Machine m")})
public class Machine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "energy_rate")
    private Double energyRate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "machine")
    private Collection<DownTime> downTimeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "machine")
    private Collection<ItemHasMachine> itemHasMachineCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "machine")
    private Collection<MachineRunningTime> machineRunningTimeCollection;
    @JoinColumn(name = "Control_point_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ControlPoint controlPoint;

    public Machine() {
    }

    public Machine(Integer id) {
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

    public Double getEnergyRate() {
        return energyRate;
    }

    public void setEnergyRate(Double energyRate) {
        this.energyRate = energyRate;
    }

    public Collection<DownTime> getDownTimeCollection() {
        return downTimeCollection;
    }

    public void setDownTimeCollection(Collection<DownTime> downTimeCollection) {
        this.downTimeCollection = downTimeCollection;
    }

    public Collection<ItemHasMachine> getItemHasMachineCollection() {
        return itemHasMachineCollection;
    }

    public void setItemHasMachineCollection(Collection<ItemHasMachine> itemHasMachineCollection) {
        this.itemHasMachineCollection = itemHasMachineCollection;
    }

    public Collection<MachineRunningTime> getMachineRunningTimeCollection() {
        return machineRunningTimeCollection;
    }

    public void setMachineRunningTimeCollection(Collection<MachineRunningTime> machineRunningTimeCollection) {
        this.machineRunningTimeCollection = machineRunningTimeCollection;
    }

    public ControlPoint getControlPoint() {
        return controlPoint;
    }

    public void setControlPoint(ControlPoint controlPoint) {
        this.controlPoint = controlPoint;
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
        if (!(object instanceof Machine)) {
            return false;
        }
        Machine other = (Machine) object;
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
