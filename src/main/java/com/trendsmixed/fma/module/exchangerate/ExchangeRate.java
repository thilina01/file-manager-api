package com.trendsmixed.fma.module.exchangerate;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.currency.Currency;
import com.trendsmixed.fma.module.invoice.Invoice;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "exchange_rate")
public class ExchangeRate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ExchangeRateView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ExchangeRateView.ExchangeRate.class)
    @Column(name = "exchange_rate")
    private Double exchangeRate;
    @JsonView(ExchangeRateView.ExchangeRateDate.class)
    @Column(name = "exchange_rate_date")
    @Temporal(TemporalType.DATE)
    private Date exchangeRateDate;
    @JsonView(ExchangeRateView.Currency.class)
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Currency currency;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "exchangeRate", fetch = FetchType.LAZY)
    private List<Invoice> invoiceList;

   
}
