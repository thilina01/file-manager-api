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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "sales_order")
@NamedQueries({
    @NamedQuery(name = "SalesOrder.findAll", query = "SELECT s FROM SalesOrder s")})
public class SalesOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "actual_dispatched_date")
    @Temporal(TemporalType.DATE)
    private Date actualDispatchedDate;
    @Column(name = "comments")
    private String comments;
    @Column(name = "customer_requested_date")
    @Temporal(TemporalType.DATE)
    private Date customerRequestedDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "order_qty")
    private Double orderQty;
    @Column(name = "order_recived_date")
    @Temporal(TemporalType.DATE)
    private Date orderRecivedDate;
    @Column(name = "po_number")
    private String poNumber;
    @Column(name = "trw_confirmed_date")
    @Temporal(TemporalType.DATE)
    private Date trwConfirmedDate;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "salesOrder")
    private SalesOrderItem salesOrderItem;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Customer customer;
    @JoinColumn(name = "order_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrderType orderType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesOrder")
    private Collection<Job> jobCollection;

    public SalesOrder() {
    }

    public SalesOrder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getActualDispatchedDate() {
        return actualDispatchedDate;
    }

    public void setActualDispatchedDate(Date actualDispatchedDate) {
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

    public Date getOrderRecivedDate() {
        return orderRecivedDate;
    }

    public void setOrderRecivedDate(Date orderRecivedDate) {
        this.orderRecivedDate = orderRecivedDate;
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

    public SalesOrderItem getSalesOrderItem() {
        return salesOrderItem;
    }

    public void setSalesOrderItem(SalesOrderItem salesOrderItem) {
        this.salesOrderItem = salesOrderItem;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Collection<Job> getJobCollection() {
        return jobCollection;
    }

    public void setJobCollection(Collection<Job> jobCollection) {
        this.jobCollection = jobCollection;
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
        if (!(object instanceof SalesOrder)) {
            return false;
        }
        SalesOrder other = (SalesOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.SalesOrder[ id=" + id + " ]";
    }
    
}
