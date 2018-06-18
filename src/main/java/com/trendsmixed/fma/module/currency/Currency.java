package com.trendsmixed.fma.module.currency;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.exchangerate.ExchangeRate;
import com.trendsmixed.fma.module.invoice.Invoice;
import com.trendsmixed.fma.module.supplier.Supplier;
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
@Table(name = "currency")
public class Currency implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(CurrencyView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(CurrencyView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(CurrencyView.Name.class)
    @Column(name = "name", unique = true)
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "currency")
    private List<Customer> customerList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "currency")
    private List<Supplier> supplierList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "currency")
    private List<ExchangeRate> exchangeRateList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "currency")
    private List<Invoice> invoiceList;

    public Currency(int anId) {
        this.id = anId;
    }
    
    @JsonView(CurrencyView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }

}
