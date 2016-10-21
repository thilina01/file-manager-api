/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.PurchaseOrderView;
import java.io.Serializable;
import java.util.Date;
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
    @JsonView(PurchaseOrderView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(PurchaseOrderView.ActualDispatchedDate.class)
    @Column(name = "actual_dispatched_date")
    private String actualDispatchedDate;
    @JsonView(PurchaseOrderView.Comments.class)
    @Column(name = "comments")
    private String comments;
    @JsonView(PurchaseOrderView.CustomerRequestedDate.class)
    @Column(name = "customer_requested_date")
    @Temporal(TemporalType.DATE)
    private Date customerRequestedDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @JsonView(PurchaseOrderView.OrderQty.class)
    @Column(name = "order_qty")
    private Double orderQty;
    @JsonView(PurchaseOrderView.OrderRecivedDate.class)
    @Column(name = "order_recived_date")
    private String orderRecivedDate;
    @JsonView(PurchaseOrderView.PoNumber.class)
    @Column(name = "po_number")
    private String poNumber;
    @JsonView(PurchaseOrderView.TrwConfirmedDate.class)
    @Column(name = "trw_confirmed_date")
    @Temporal(TemporalType.DATE)
    private Date trwConfirmedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrder")
    private List<PurchaseOrderHasItem> purchaseOrderHasItemList;
    @JsonView(PurchaseOrderView.Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Customer customer;
    @JsonView(PurchaseOrderView.PurchaseOrderType.class)
    @JoinColumn(name = "purchase_order_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PurchaseOrderType purchaseOrderType;

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

    public String getActualDispatchedDate() {
        return actualDispatchedDate;
    }

    public void setActualDispatchedDate(String actualDispatchedDate) {
        this.actualDispatchedDate = actualDispatchedDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getCustomerRequestedDate() {
        return customerRequestedDate;
    }

    public void setCustomerRequestedDate(Date customerRequestedDate) {
        this.customerRequestedDate = customerRequestedDate;
    }

    public Double getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Double orderQty) {
        this.orderQty = orderQty;
    }

    public String getOrderRecivedDate() {
        return orderRecivedDate;
    }

    public void setOrderRecivedDate(String orderRecivedDate) {
        this.orderRecivedDate = orderRecivedDate;
    }

    public PurchaseOrderType getPurchaseOrderType() {
        return purchaseOrderType;
    }

    public void setPurchaseOrderType(PurchaseOrderType purchaseOrderType) {
        this.purchaseOrderType = purchaseOrderType;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public Date getTrwConfirmedDate() {
        return trwConfirmedDate;
    }

    public void setTrwConfirmedDate(Date trwConfirmedDate) {
        this.trwConfirmedDate = trwConfirmedDate;
    }

    public List<PurchaseOrderHasItem> getPurchaseOrderHasItemList() {
        return purchaseOrderHasItemList;
    }

    public void setPurchaseOrderHasItemList(List<PurchaseOrderHasItem> purchaseOrderHasItemList) {
        this.purchaseOrderHasItemList = purchaseOrderHasItemList;
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
