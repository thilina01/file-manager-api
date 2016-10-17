/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "purchase_order_has_item")
@NamedQueries({
    @NamedQuery(name = "PurchaseOrderHasItem.findAll", query = "SELECT p FROM PurchaseOrderHasItem p")})
public class PurchaseOrderHasItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurchaseOrderHasItemPK purchaseOrderHasItemPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity")
    private Double quantity;
    @JoinColumn(name = "item_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;
    @JoinColumn(name = "purchase_order_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PurchaseOrder purchaseOrder;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderHasItem")
    private List<Delivery> deliveryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderHasItem")
    private List<Job> jobList;

    public PurchaseOrderHasItem() {
    }

    public PurchaseOrderHasItem(PurchaseOrderHasItemPK purchaseOrderHasItemPK) {
        this.purchaseOrderHasItemPK = purchaseOrderHasItemPK;
    }

    public PurchaseOrderHasItem(int itemId, int purchaseOrderId) {
        this.purchaseOrderHasItemPK = new PurchaseOrderHasItemPK(itemId, purchaseOrderId);
    }

    public PurchaseOrderHasItemPK getPurchaseOrderHasItemPK() {
        return purchaseOrderHasItemPK;
    }

    public void setPurchaseOrderHasItemPK(PurchaseOrderHasItemPK purchaseOrderHasItemPK) {
        this.purchaseOrderHasItemPK = purchaseOrderHasItemPK;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public List<Delivery> getDeliveryList() {
        return deliveryList;
    }

    public void setDeliveryList(List<Delivery> deliveryList) {
        this.deliveryList = deliveryList;
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseOrderHasItemPK != null ? purchaseOrderHasItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrderHasItem)) {
            return false;
        }
        PurchaseOrderHasItem other = (PurchaseOrderHasItem) object;
        if ((this.purchaseOrderHasItemPK == null && other.purchaseOrderHasItemPK != null) || (this.purchaseOrderHasItemPK != null && !this.purchaseOrderHasItemPK.equals(other.purchaseOrderHasItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.PurchaseOrderHasItem[ purchaseOrderHasItemPK=" + purchaseOrderHasItemPK + " ]";
    }
    
}
