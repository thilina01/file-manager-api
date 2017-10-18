package com.trendsmixed.fma.module.salesorder;

import com.trendsmixed.fma.module.customer.Customer;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItem;
import com.trendsmixed.fma.module.salesordertype.SalesOrderType;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "sales_order")
@NamedQueries({
    @NamedQuery(name = "SalesOrder.findAll", query = "SELECT s FROM SalesOrder s")})
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
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "salesOrder")
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

    public SalesOrder(int anId) {
        this.id = anId;
    }

}
