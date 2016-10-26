/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.ItemMachineView;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "item_machine")
@NamedQueries({
    @NamedQuery(name = "ItemMachine.findAll", query = "SELECT i FROM ItemMachine i")})
public class ItemMachine implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @JsonView(ItemMachineView.ConsumptionRate.class)
    @Column(name = "consumption_rate")
    private Double consumptionRate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ItemMachineView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ItemMachineView.Machine.class)
    @JoinColumn(name = "machine_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Machine machine;
    @JsonView(ItemMachineView.Item.class)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Item item;

    public ItemMachine() {
    }

    public ItemMachine(Integer id) {
        this.id = id;
    }

    public Double getConsumptionRate() {
        return consumptionRate;
    }

    public void setConsumptionRate(Double consumptionRate) {
        this.consumptionRate = consumptionRate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
        if (!(object instanceof ItemMachine)) {
            return false;
        }
        ItemMachine other = (ItemMachine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.ItemMachine[ id=" + id + " ]";
    }
    
}
