/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.salesorder;

import com.trendsmixed.fma.module.customer.Customer;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItem;
import com.trendsmixed.fma.module.salesordertype.SalesOrderType;
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
import lombok.Data;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@Table(name = "sales_order")
@NamedQueries({
    @NamedQuery(name = "SalesOrder.findAll", query = "SELECT s FROM SalesOrder s")})
public class SalesOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(SalesOrderView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(SalesOrderView.ActualDispatchedDate.class)
    @Column(name = "actual_dispatched_date")
    @Temporal(TemporalType.DATE)
    private Date actualDispatchedDate;
    @JsonView(SalesOrderView.Comments.class)
    @Column(name = "comments")
    private String comments;
    @JsonView(SalesOrderView.CustomerRequestedDate.class)
    @Column(name = "customer_requested_date")
    @Temporal(TemporalType.DATE)
    private Date customerRequestedDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @JsonView(SalesOrderView.OrderQty.class)
    @Column(name = "order_qty")
    private Double orderQty;
    @JsonView(SalesOrderView.OrderReceivedDate.class)
    @Column(name = "order_received_date")
    @Temporal(TemporalType.DATE)
    private Date orderReceivedDate;
    @JsonView(SalesOrderView.PoNumber.class)
    @Column(name = "po_number")
    private String poNumber;
    @JsonView(SalesOrderView.TrwConfirmedDate.class)
    @Column(name = "trw_confirmed_date")
    @Temporal(TemporalType.DATE)
    private Date trwConfirmedDate;
    @JsonView(SalesOrderView.SalesOrderItemList.class)
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "salesOrder")
    private List<SalesOrderItem> salesOrderItemList;
    @JsonView(SalesOrderView.Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Customer customer;
    @JsonView(SalesOrderView.SalesOrderType.class)
    @JoinColumn(name = "order_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SalesOrderType salesOrderType;

    public SalesOrder() {
    }

    public SalesOrder(Integer id) {
        this.id = id;
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
