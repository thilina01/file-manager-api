/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.CustomerItemView;
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
@Table(name = "customer_item")
@NamedQueries({
    @NamedQuery(name = "CustomerItem.findAll", query = "SELECT c FROM CustomerItem c")})
public class CustomerItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(CustomerItemView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(CustomerItemView.CustomerPartNo.class)
    @Column(name = "customer_part_no")
    private String customerPartNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @JsonView(CustomerItemView.Price.class)
    @Column(name = "price")
    private Double price;
    @JsonView(CustomerItemView.Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Customer customer;
    @JsonView(CustomerItemView.Item.class)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Item item;

    public CustomerItem() {
    }

    public CustomerItem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerPartNo() {
        return customerPartNo;
    }

    public void setCustomerPartNo(String customerPartNo) {
        this.customerPartNo = customerPartNo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        if (!(object instanceof CustomerItem)) {
            return false;
        }
        CustomerItem other = (CustomerItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.CustomerItem[ id=" + id + " ]";
    }
    
}
