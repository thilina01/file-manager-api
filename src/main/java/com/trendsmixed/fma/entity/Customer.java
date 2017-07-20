/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.customer.CustomerView;
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

/**
 *
 * @author Thilina
 */
@Entity
@Data
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
    @JsonView(CustomerView.ShortName.class)
    @Column(name = "short_name")
    private String shortName;
    @JsonView(CustomerView.Note.class)
    @Column(name = "note")
    private String note;
    @JsonView(CustomerView.SpecialRequirements.class)
    @Column(name = "special_requirements")
    private String specialRequirements;
    @JsonView(CustomerView.OfficeAddress.class)
    @Column(name = "office_address")
    private String officeAddress;
    @JsonView(CustomerView.PhoneNo.class)
    @Column(name = "phone_no")
    private String phoneNo;
    @JsonView(CustomerView.SVatNo.class)
    @Column(name = "s_vat_no")
    private String sVatNo;
    @JsonView(CustomerView.VatNo.class)
    @Column(name = "vat_no")
    private String vatNo;
    @JsonView(CustomerView.CustomerItemList.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
    private List<CustomerItem> customerItemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
    private List<SalesOrder> salesOrderList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Dispatch> dispatchs;
    @JsonView(CustomerView.Incoterm.class)
    @JoinColumn(name = "incoterm_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Incoterm incoterm;
    @JsonView(CustomerView.Currency.class)
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Currency currency;
    @JsonView(CustomerView.CustomerType.class)
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CustomerType customerType;
    @JsonView(CustomerView.Country.class)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Country country;
    @JoinColumn(name = "notify_party_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private NotifyParty notifyParty;
    @JoinColumn(name = "payment_term_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private PaymentTerm paymentTerm;

    public Customer() {
    }

    public Customer(Integer id) {
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
