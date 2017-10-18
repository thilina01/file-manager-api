/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.customer;

import com.trendsmixed.fma.module.currency.Currency;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.address.Address;
import com.trendsmixed.fma.module.contact.Contact;
import com.trendsmixed.fma.module.customeritem.CustomerItem;
import com.trendsmixed.fma.module.customertype.CustomerType;
import com.trendsmixed.fma.module.dispatchnote.DispatchNote;
import com.trendsmixed.fma.module.incoterm.Incoterm;
import com.trendsmixed.fma.module.notifyparty.NotifyParty;
import com.trendsmixed.fma.module.paymentterm.PaymentTerm;
import com.trendsmixed.fma.module.salesorder.SalesOrder;
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
    @Column(name = "code", unique = true)
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
    @JsonView(CustomerView.ContactNumber.class)
    @Column(name = "contact_number")
    private String contactNumber;
    @JsonView(CustomerView.SVatNo.class)
    @Column(name = "s_vat_no")
    private String sVatNo;
    @JsonView(CustomerView.VatNo.class)
    @Column(name = "vat_no")
    private String vatNo;
    @JsonView(CustomerView.CustomerItemList.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "customer", fetch = FetchType.LAZY)
    private List<CustomerItem> customerItemList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "customer", fetch = FetchType.LAZY)
    private List<SalesOrder> salesOrderList;
    @JsonView(CustomerView.Contact.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Contact> contactList;
    @JsonView(CustomerView.Address.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Address> addressList;
    @JsonView(CustomerView.DispatchNote.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "customer", fetch = FetchType.LAZY)
    private List<DispatchNote> dispatchNoteList;
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
    @JsonView(CustomerView.NotifyParty.class)
    @JoinColumn(name = "notify_party_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private NotifyParty notifyParty;
    @JsonView(CustomerView.PaymentTerm.class)
    @JoinColumn(name = "payment_term_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private PaymentTerm paymentTerm;

    public Customer(int anId) {
        this.id = anId;
    }

}
