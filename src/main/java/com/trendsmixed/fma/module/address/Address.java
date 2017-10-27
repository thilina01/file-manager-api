package com.trendsmixed.fma.module.address;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.addresstype.AddressType;
import com.trendsmixed.fma.module.country.Country;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.dispatchnote.DispatchNote;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
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
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer customer;
    @JsonView(AddressView.Country.class)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Country country;
    @JsonView(AddressView.DispatchNote.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "address")
    private List<DispatchNote> dispatchNoteList;

}
