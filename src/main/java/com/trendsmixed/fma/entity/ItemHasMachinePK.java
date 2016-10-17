/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Thilina
 */
@Embeddable
public class ItemHasMachinePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "item_id")
    private int itemId;
    @Basic(optional = false)
    @Column(name = "machine_id")
    private int machineId;

    public ItemHasMachinePK() {
    }

    public ItemHasMachinePK(int itemId, int machineId) {
        this.itemId = itemId;
        this.machineId = machineId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) itemId;
        hash += (int) machineId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemHasMachinePK)) {
            return false;
        }
        ItemHasMachinePK other = (ItemHasMachinePK) object;
        if (this.itemId != other.itemId) {
            return false;
        }
        if (this.machineId != other.machineId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.ItemHasMachinePK[ itemId=" + itemId + ", machineId=" + machineId + " ]";
    }
    
}
