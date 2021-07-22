package com.trendsmixed.fma.module.salesorder;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.arbranch.ArBranch;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.incoterm.Incoterm;
import com.trendsmixed.fma.module.paymentterm.PaymentTerm;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItem;
import com.trendsmixed.fma.module.salesordertype.SalesOrderType;
import com.trendsmixed.fma.module.salesperson.SalesPerson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "sales_order")
public class SalesOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(SalesOrderView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(SalesOrderView.Comments.class)
    @Column(name = "comments")
    private String comments;
    @JsonView(SalesOrderView.Quantity.class)
    @Column(name = "quantity")
    private Double quantity;
    @JsonView(SalesOrderView.Amount.class)
    @Column(name = "amount")
    private Double amount;
    @JsonView(SalesOrderView.OrderReceivedDate.class)
    @Column(name = "order_received_date")
    @Temporal(TemporalType.DATE)
    private Date orderReceivedDate;
    @JsonView(SalesOrderView.CustomerPONumber.class)
    @Column(name = "customer_po_number")
    private String customerPoNumber;
    @JsonView(SalesOrderView.SalesOrderItem.class)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "salesOrder")
    private List<SalesOrderItem> salesOrderItemList;
    @JsonView(SalesOrderView.Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Customer customer;
    @JsonView(SalesOrderView.SalesOrderType.class)
    @JoinColumn(name = "order_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SalesOrderType salesOrderType;
    @JsonView(SalesOrderView.OrderDate.class)
    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @JsonView(SalesOrderView.SalesOrderNumber.class)
    @Column(name = "sales_order_number")
    private String salesOrderNumber;
    @JsonView(SalesOrderView.Action.class)
    @Column(name = "action")
    private String action;
    @JsonView(SalesOrderView.CurrencyCode.class)
    @Column(name = "currency_code")
    private String currencyCode;
    @JsonView(SalesOrderView.Address.class)
    @Column(name = "address")
    private String address;
    @JsonView(SalesOrderView.ExchangeRate.class)
    @Column(name = "exchange_rate")
    private Double exchangeRate;
    @JsonView(SalesOrderView.Operator.class)
    @Column(name = "operator")
    private String operator;
    @JsonView(SalesOrderView.CustomerRequestedDate.class)
    @Column(name = "customer_requested_date")
    @Temporal(TemporalType.DATE)
    private Date customerRequestedDate;
    @JsonView(SalesOrderView.ShippingInstruction.class)
    @Column(name = "shipping_instruction")
    private String shippingInstruction;
    @JsonView(SalesOrderView.ArBranch.class)
    @JoinColumn(name = "ar_branch_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private ArBranch arBranch;
    @JsonView(SalesOrderView.SalesPerson.class)
    @JoinColumn(name = "sales_person_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private SalesPerson salesPerson;
    @JsonView(SalesOrderView.PaymentTerm.class)
    @JoinColumn(name = "payment_term_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private PaymentTerm paymentTerm;
    @JsonView(SalesOrderView.Incoterm.class)
    @JoinColumn(name = "incoterm_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Incoterm incoterm;

    public SalesOrder(int anId) {
        this.id = anId;
    }

    @JsonView(SalesOrderView.Display.class)
    public String getDisplay() {
        return (customerPoNumber != null ? customerPoNumber : "") + " : " + (customer != null ? customer.getCode() : "");
    }
}
