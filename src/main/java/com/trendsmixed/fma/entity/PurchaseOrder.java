/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "purchase_order")
@NamedQueries({
    @NamedQuery(name = "PurchaseOrder.findAll", query = "SELECT p FROM PurchaseOrder p")})
public class PurchaseOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "po_number")
    private String poNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "order_qty")
    private Double orderQty;
    @Column(name = "customer_requested_date")
    @Temporal(TemporalType.DATE)
    private Date customerRequestedDate;
    @Column(name = "trw_confirmed_date")
    @Temporal(TemporalType.DATE)
    private Date trwConfirmedDate;
    @Column(name = "order_recived_date")
    private String orderRecivedDate;
    @Column(name = "order_type")
    private String orderType;
    @Column(name = "actual_despatch_date")
    private String actualDespatchDate;
    @Column(name = "comments")
    private String comments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrder")
    private Collection<PurchaseOrderHasItem> purchaseOrderHasItemCollection;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Customer customer;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public Double getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Double orderQty) {
        this.orderQty = orderQty;
    }

    public Date getCustomerRequestedDate() {
        return customerRequestedDate;
    }

    public void setCustomerRequestedDate(Date customerRequestedDate) {
        this.customerRequestedDate = customerRequestedDate;
    }

    public Date getTrwConfirmedDate() {
        return trwConfirmedDate;
    }

    public void setTrwConfirmedDate(Date trwConfirmedDate) {
        this.trwConfirmedDate = trwConfirmedDate;
    }

    public String getOrderRecivedDate() {
        return orderRecivedDate;
    }

    public void setOrderRecivedDate(String orderRecivedDate) {
        this.orderRecivedDate = orderRecivedDate;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getActualDespatchDate() {
        return actualDespatchDate;
    }

    public void setActualDespatchDate(String actualDespatchDate) {
        this.actualDespatchDate = actualDespatchDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Collection<PurchaseOrderHasItem> getPurchaseOrderHasItemCollection() {
        return purchaseOrderHasItemCollection;
    }

    public void setPurchaseOrderHasItemCollection(Collection<PurchaseOrderHasItem> purchaseOrderHasItemCollection) {
        this.purchaseOrderHasItemCollection = purchaseOrderHasItemCollection;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        if (!(object instanceof PurchaseOrder)) {
            return false;
        }
        PurchaseOrder other = (PurchaseOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.PurchaseOrder[ id=" + id + " ]";
    }
    
}
