/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "customer")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "office_addres")
    private String officeAddres;
    @Column(name = "consignee")
    private String consignee;
    @Column(name = "nortify_party")
    private String nortifyParty;
    @Column(name = "contact")
    private String contact;
    @Column(name = "phone_no")
    private String phoneNo;
    @Column(name = "fax")
    private String fax;
    @Column(name = "payment_term")
    private String paymentTerm;
    @Column(name = "vat_no")
    private String vatNo;
    @Column(name = "s_vat_no")
    private String sVatNo;
    @Column(name = "final_destination")
    private String finalDestination;
    @Column(name = "continent")
    private String continent;
    @Column(name = "note")
    private String note;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Collection<CustomerItem> customerItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Collection<PurchaseOrder> purchaseOrderCollection;
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country country;
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Currency currency;
    @JoinColumn(name = "cust_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CustType custType;
    @JoinColumn(name = "incoterm_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Incoterm incoterm;

    public Customer() {
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficeAddres() {
        return officeAddres;
    }

    public void setOfficeAddres(String officeAddres) {
        this.officeAddres = officeAddres;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getNortifyParty() {
        return nortifyParty;
    }

    public void setNortifyParty(String nortifyParty) {
        this.nortifyParty = nortifyParty;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(String paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public String getVatNo() {
        return vatNo;
    }

    public void setVatNo(String vatNo) {
        this.vatNo = vatNo;
    }

    public String getSVatNo() {
        return sVatNo;
    }

    public void setSVatNo(String sVatNo) {
        this.sVatNo = sVatNo;
    }

    public String getFinalDestination() {
        return finalDestination;
    }

    public void setFinalDestination(String finalDestination) {
        this.finalDestination = finalDestination;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Collection<CustomerItem> getCustomerItemCollection() {
        return customerItemCollection;
    }

    public void setCustomerItemCollection(Collection<CustomerItem> customerItemCollection) {
        this.customerItemCollection = customerItemCollection;
    }

    public Collection<PurchaseOrder> getPurchaseOrderCollection() {
        return purchaseOrderCollection;
    }

    public void setPurchaseOrderCollection(Collection<PurchaseOrder> purchaseOrderCollection) {
        this.purchaseOrderCollection = purchaseOrderCollection;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public CustType getCustType() {
        return custType;
    }

    public void setCustType(CustType custType) {
        this.custType = custType;
    }

    public Incoterm getIncoterm() {
        return incoterm;
    }

    public void setIncoterm(Incoterm incoterm) {
        this.incoterm = incoterm;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.Customer[ id=" + id + " ]";
    }
    
}
