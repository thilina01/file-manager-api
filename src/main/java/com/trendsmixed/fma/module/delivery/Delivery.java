package com.trendsmixed.fma.module.delivery;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItem;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "delivery")
public class Delivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(DeliveryView.Id.class)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @JsonView(DeliveryView.DeliverdQuantity.class)
    @Column(name = "deliverd_quantity")
    private Double deliverdQuantity;
    @JsonView(DeliveryView.DeliveryDate.class)
    @Column(name = "delivery_date")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    @JsonView(DeliveryView.Location.class)
    @Column(name = "location")
    private String location;
    @JsonView(DeliveryView.SalesOrderItem.class)
    @JoinColumn(name = "sales_order_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SalesOrderItem salesOrderItem;

}
