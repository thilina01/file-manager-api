/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.CustomerView;
import java.io.Serializable;
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
    @JsonView(CustomerView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(CustomerView.Code.class)
    @Column(name = "code")
    private String code;
    @JsonView(CustomerView.Consignee.class)
    @Column(name = "consignee")
    private String consignee;
    @JsonView(CustomerView.Contact.class)
    @Column(name = "contact")
    private String contact;
    @JsonView(CustomerView.Continent.class)
    @Column(name = "continent")
    private String continent;
    @JsonView(CustomerView.Fax.class)
    @Column(name = "fax")
    private String fax;
    @JsonView(CustomerView.FinalDestination.class)
    @Column(name = "final_destination")
    private String finalDestination;
    @JsonView(CustomerView.Name.class)
    @Column(name = "name")
    private String name;
    @JsonView(CustomerView.NortifyParty.class)
    @Column(name = "nortify_party")
    private String nortifyParty;
    @JsonView(CustomerView.Note.class)
    @Column(name = "note")
    private String note;
    @JsonView(CustomerView.OfficeAddress.class)
    @Column(name = "office_addres")
    private String officeAddres;
    @JsonView(CustomerView.PaymentTerm.class)
    @Column(name = "payment_term")
    private String paymentTerm;
    @JsonView(CustomerView.PhoneNo.class)
    @Column(name = "phone_no")
    private String phoneNo;
    @JsonView(CustomerView.SVatNo.class)
    @Column(name = "s_vat_no")
    private String sVatNo;
    @JsonView(CustomerView.VatNo.class)
    @Column(name = "vat_no")
    private String vatNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<CustomerItem> customerItemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<PurchaseOrder> purchaseOrderList;
    @JsonView(CustomerView.Incoterm.class)
    @JoinColumn(name = "incoterm_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Incoterm incoterm;
    @JsonView(CustomerView.Currency.class)
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Currency currency;
    @JsonView(CustomerView.CustType.class)
    @JoinColumn(name = "cust_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CustType custType;
    @JsonView(CustomerView.Country.class)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country country;

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

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFinalDestination() {
        return finalDestination;
    }

    public void setFinalDestination(String finalDestination) {
        this.finalDestination = finalDestination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNortifyParty() {
        return nortifyParty;
    }

    public void setNortifyParty(String nortifyParty) {
        this.nortifyParty = nortifyParty;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOfficeAddres() {
        return officeAddres;
    }

    public void setOfficeAddres(String officeAddres) {
        this.officeAddres = officeAddres;
    }

    public String getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(String paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getSVatNo() {
        return sVatNo;
    }

    public void setSVatNo(String sVatNo) {
        this.sVatNo = sVatNo;
    }

    public String getVatNo() {
        return vatNo;
    }

    public void setVatNo(String vatNo) {
        this.vatNo = vatNo;
    }

    public List<CustomerItem> getCustomerItemList() {
        return customerItemList;
    }

    public void setCustomerItemList(List<CustomerItem> customerItemList) {
        this.customerItemList = customerItemList;
    }

    public List<PurchaseOrder> getPurchaseOrderList() {
        return purchaseOrderList;
    }

    public void setPurchaseOrderList(List<PurchaseOrder> purchaseOrderList) {
        this.purchaseOrderList = purchaseOrderList;
    }

    public Incoterm getIncoterm() {
        return incoterm;
    }

    public void setIncoterm(Incoterm incoterm) {
        this.incoterm = incoterm;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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
