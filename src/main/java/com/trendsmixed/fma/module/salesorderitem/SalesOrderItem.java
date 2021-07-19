package com.trendsmixed.fma.module.salesorderitem;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.customeritem.CustomerItem;
import com.trendsmixed.fma.module.delivery.Delivery;
import com.trendsmixed.fma.module.dispatchschedule.DispatchSchedule;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.salesorder.SalesOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "sales_order_item", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"customer_item_id", "sales_order_id"})})
public class SalesOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(SalesOrderItemView.Id.class)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @JsonView(SalesOrderItemView.Quantity.class)
    @Column(name = "quantity")
    private Double quantity;
    @JsonView(SalesOrderItemView.Scheduled.class)
    @JsonInclude()
    @Transient
    private int scheduled;
    @JsonView(SalesOrderItemView.UnitPrice.class)
    @Column(name = "unit_price")
    private Double unitPrice;
    @JsonView(SalesOrderItemView.Amount.class)
    @Column(name = "amount")
    private Double amount;
    @JsonView(SalesOrderItemView.Remarks.class)
    @Column(name = "remarks")
    private String remarks;
    @JsonView(SalesOrderItemView.CustomerItem.class)
    @JoinColumn(name = "customer_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CustomerItem customerItem;
    @JsonView(SalesOrderItemView.SalesOrder.class)
    @JoinColumn(name = "sales_order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)//cascade = {CascadeType.MERGE, CascadeType.PERSIST},
    private SalesOrder salesOrder;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "salesOrderItem")
    private List<Delivery> deliveryList;
    @JsonView(SalesOrderItemView.Job.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "salesOrderItem")
    private List<Job> jobList;
    @JsonView(SalesOrderItemView.DispatchSchedule.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "salesOrderItem")
    private List<DispatchSchedule> dispatchScheduleList;

    public SalesOrderItem(Integer anId) {
        this.id = anId;
    }

    public void setScheduled(int anAllocated) {
    }

    public int getScheduled() {
        scheduled = 0;
        if (dispatchScheduleList != null) {
            for (DispatchSchedule dispatchSchedule : dispatchScheduleList) {
                scheduled += dispatchSchedule.getQuantity() != null ? dispatchSchedule.getQuantity() : 0;
            }
        }
        return scheduled;
    }
}
