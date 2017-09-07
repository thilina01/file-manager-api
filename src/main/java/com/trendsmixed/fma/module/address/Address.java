/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.address;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.addresstype.AddressType;
import com.trendsmixed.fma.module.country.Country;
import com.trendsmixed.fma.module.customer.Customer;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "address")
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT c FROM Address c")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(AddressView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(AddressView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(AddressView.Name.class)
    @Column(name = "name", unique = true)
    private String name;
    @JsonView(AddressView.Line1.class)
    @Column(name = "line1", unique = true)
    private String line1;
    @JsonView(AddressView.Line2.class)
    @Column(name = "line2", unique = true)
    private String line2;
    @JsonView(AddressView.Line3.class)
    @Column(name = "line3", unique = true)
    private String line3;
    @JsonView(AddressView.Line4.class)
    @Column(name = "line4", unique = true)
    private String line4;
    @JsonView(AddressView.Line5.class)
    @Column(name = "line5", unique = true)
    private String line5;
    @JsonView(AddressView.AddressType.class)
    @JoinColumn(name = "address_type_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private AddressType addressType;
    @JsonView(AddressView.Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)//, fetch = FetchType.LAZY
    private Customer customer;
    @JsonView(AddressView.Country.class)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)//, fetch = FetchType.LAZY
    private Country country;
    
    
    
    
    
    
    
    
   
    
    
   
}
