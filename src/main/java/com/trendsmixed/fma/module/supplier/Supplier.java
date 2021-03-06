package com.trendsmixed.fma.module.supplier;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.currency.Currency;
import com.trendsmixed.fma.module.deliveryterm.DeliveryTerm;
import com.trendsmixed.fma.module.paymentterm.PaymentTerm;
import com.trendsmixed.fma.module.suppliertype.SupplierType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Thilina
 */


@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "supplier")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(SupplierView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(SupplierView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(SupplierView.Name.class)
    @Column(name = "name")
    private String name;
    @JsonView(SupplierView.Fax.class)
    @Column(name = "fax")
    private String fax;
    @JsonView(SupplierView.Email.class)
    @Column(name = "email")
    private String email;
    @JsonView(SupplierView.ContactPerson.class)
    @Column(name = "contact_person")
    private String contactPerson;
    @JsonView(SupplierView.ShortName.class)
    @Column(name = "short_name")
    private String shortName;
    @JsonView(SupplierView.Contact.class)
    @Column(name = "contact")
    private String contact;
    @JsonView(SupplierView.Address.class)
    @Column(name = "address")
    private String address;
    @JsonView(SupplierView.Currency.class)
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Currency currency;
    @JsonView(SupplierView.SupplierType.class)
    @JoinColumn(name = "supplier_type_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private SupplierType supplierType;
    @JsonView(SupplierView.PaymentTerm.class)
    @JoinColumn(name = "payment_term_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private PaymentTerm paymentTerm;
    @JsonView(SupplierView.DeliveryTerm.class)
    @JoinColumn(name = "delivery_term_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private DeliveryTerm deliveryTerm;

    @JsonView(SupplierView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
