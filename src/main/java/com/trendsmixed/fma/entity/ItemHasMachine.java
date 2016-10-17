/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "item_has_machine")
@NamedQueries({
    @NamedQuery(name = "ItemHasMachine.findAll", query = "SELECT i FROM ItemHasMachine i")})
public class ItemHasMachine implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemHasMachinePK itemHasMachinePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "consumption_rate")
    private Double consumptionRate;
    @JoinColumn(name = "item_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;
    @JoinColumn(name = "machine_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Machine machine;

    public ItemHasMachine() {
    }

    public ItemHasMachine(ItemHasMachinePK itemHasMachinePK) {
        this.itemHasMachinePK = itemHasMachinePK;
    }

    public ItemHasMachine(int itemId, int machineId) {
        this.itemHasMachinePK = new ItemHasMachinePK(itemId, machineId);
    }

    public ItemHasMachinePK getItemHasMachinePK() {
        return itemHasMachinePK;
    }

    public void setItemHasMachinePK(ItemHasMachinePK itemHasMachinePK) {
        this.itemHasMachinePK = itemHasMachinePK;
    }

    public Double getConsumptionRate() {
        return consumptionRate;
    }

    public void setConsumptionRate(Double consumptionRate) {
        this.consumptionRate = consumptionRate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemHasMachinePK != null ? itemHasMachinePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemHasMachine)) {
            return false;
        }
        ItemHasMachine other = (ItemHasMachine) object;
        if ((this.itemHasMachinePK == null && other.itemHasMachinePK != null) || (this.itemHasMachinePK != null && !this.itemHasMachinePK.equals(other.itemHasMachinePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.ItemHasMachine[ itemHasMachinePK=" + itemHasMachinePK + " ]";
    }
    
}
