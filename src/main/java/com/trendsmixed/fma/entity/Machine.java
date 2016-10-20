/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.MachineView;
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
    @JsonView(MachineView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(MachineView.Code.class)
    @Column(name = "code")
    private String code;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @JsonView(MachineView.EnergyRate.class)
    @Column(name = "energy_rate")
    private Double energyRate;
    @JsonView(MachineView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "machine")
    private List<DownTime> downTimeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "machine")
    private List<ItemHasMachine> itemHasMachineList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "machine")
    private List<MachineRunningTime> machineRunningTimeList;
    @JsonView(MachineView.WorkCenter.class)
    @JoinColumn(name = "work_center_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private WorkCenter workCenter;

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

    public Double getEnergyRate() {
        return energyRate;
    }

    public void setEnergyRate(Double energyRate) {
        this.energyRate = energyRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DownTime> getDownTimeList() {
        return downTimeList;
    }

    public void setDownTimeList(List<DownTime> downTimeList) {
        this.downTimeList = downTimeList;
    }

    public List<ItemHasMachine> getItemHasMachineList() {
        return itemHasMachineList;
    }

    public void setItemHasMachineList(List<ItemHasMachine> itemHasMachineList) {
        this.itemHasMachineList = itemHasMachineList;
    }

    public List<MachineRunningTime> getMachineRunningTimeList() {
        return machineRunningTimeList;
    }

    public void setMachineRunningTimeList(List<MachineRunningTime> machineRunningTimeList) {
        this.machineRunningTimeList = machineRunningTimeList;
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
