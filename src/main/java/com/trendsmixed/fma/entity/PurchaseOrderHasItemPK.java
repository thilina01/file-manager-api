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
public class PurchaseOrderHasItemPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "purchase_order_id")
    private int purchaseOrderId;
    @Basic(optional = false)
    @Column(name = "item_id")
    private int itemId;

    public PurchaseOrderHasItemPK() {
    }

    public PurchaseOrderHasItemPK(int purchaseOrderId, int itemId) {
        this.purchaseOrderId = purchaseOrderId;
        this.itemId = itemId;
    }

    public int getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(int purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) purchaseOrderId;
        hash += (int) itemId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrderHasItemPK)) {
            return false;
        }
        PurchaseOrderHasItemPK other = (PurchaseOrderHasItemPK) object;
        if (this.purchaseOrderId != other.purchaseOrderId) {
            return false;
        }
        if (this.itemId != other.itemId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.PurchaseOrderHasItemPK[ purchaseOrderId=" + purchaseOrderId + ", itemId=" + itemId + " ]";
    }
    
}
