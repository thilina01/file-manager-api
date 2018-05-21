package com.trendsmixed.fma.module.invoice;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.currency.Currency;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.dispatchnote.DispatchNote;
import com.trendsmixed.fma.module.employee.Employee;
import com.trendsmixed.fma.module.exchangerate.ExchangeRate;
import com.trendsmixed.fma.module.invoicetype.InvoiceType;
import com.trendsmixed.fma.module.loadingplan.LoadingPlan;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "invoice")
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(InvoiceView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(InvoiceView.InvoiceDate.class)
    @Column(name = "invoice_date")
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    @JsonView(InvoiceView.TotalAmount.class)
    @Column(name = "totalAmount")
    private Double totalAmount;
    @JsonView(InvoiceView.TotalWeight.class)
    @Column(name = "totalWeight")
    private Double totalWeight;
    @JsonView(InvoiceView.InvoiceNumber.class)
    @Column(name = "invoice_number")
    private String invoiceNumber;
    @JsonView(InvoiceView.InvoiceType.class)
    @JoinColumn(name = "invoice_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InvoiceType invoiceType;
    @JsonView(InvoiceView.TaxRate.class)
    @Column(name = "taxRate")
    private Double taxRate;
    @JsonView(InvoiceView.Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Customer customer;
    @JsonView(InvoiceView.Employee.class)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Employee employee;
    @JsonView(InvoiceView.ExchangeRate.class)
    @JoinColumn(name = "exchange_rate_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private ExchangeRate exchangeRate;
    @JsonView(InvoiceView.Currency.class)
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Currency currency;
    @JsonView(InvoiceView.DispatchNote.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "invoice", fetch = FetchType.LAZY)
    private List<DispatchNote> dispatchNoteList;
    public Invoice(Integer id) {
        this.id = id;
    }

}
