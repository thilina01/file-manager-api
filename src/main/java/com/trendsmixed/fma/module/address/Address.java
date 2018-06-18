package com.trendsmixed.fma.module.address;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.addresstype.AddressType;
import com.trendsmixed.fma.module.country.Country;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.loadingplan.LoadingPlan;
import com.trendsmixed.fma.module.port.Port;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    @JsonView(AddressView.Line1.class)
    @Column(name = "line1")
    private String line1;
    @JsonView(AddressView.Line2.class)
    @Column(name = "line2")
    private String line2;
    @JsonView(AddressView.Line3.class)
    @Column(name = "line3")
    private String line3;
    @JsonView(AddressView.Line4.class)
    @Column(name = "line4")
    private String line4;
    @JsonView(AddressView.Line5.class)
    @Column(name = "line5")
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
    @JsonView(AddressView.Port.class)
    @JoinColumn(name = "port_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Port port;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "address", fetch = FetchType.LAZY)
    private List<LoadingPlan> loadingPlanList;
    
    @JsonView(AddressView.All.class)
    public String getDisplay() {
        return line1 + ", " +line2 + ", " +line3 + ", " +line4 + ", " +line5;


    }
}
