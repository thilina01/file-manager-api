/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.customeritem;

import com.trendsmixed.fma.module.customer.Customer;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.item.Item;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@Table(name = "customer_item", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"item_id", "customer_id"})})/*
@NamedQueries({
    @NamedQuery(name = "CustomerItem.findAll", query = "SELECT c FROM CustomerItem c")})*/
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
    @ManyToOne(optional = false, fetch = FetchType.LAZY)//, fetch = FetchType.LAZY
    private Customer customer;
    @JsonView(CustomerItemView.Item.class)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)//, fetch = FetchType.LAZY
    private Item item;

}
