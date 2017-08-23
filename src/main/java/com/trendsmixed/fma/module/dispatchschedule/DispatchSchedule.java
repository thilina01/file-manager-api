/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.dispatchschedule;

import com.trendsmixed.fma.module.item.Item;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.operation.Operation;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItem;
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
@Table(name = "dispatch_schedule")
@NamedQueries({
    @NamedQuery(name = "DispatchSchedule.findAll", query = "SELECT j FROM DispatchSchedule j")})
public class DispatchSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(DispatchScheduleView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(DispatchScheduleView.DispatchDate.class)
    @Column(name = "dispatch_date")
    @Temporal(TemporalType.DATE)
    private Date dispatchDate;
    @JsonView(DispatchScheduleView.Comment.class)
    @Column(name = "comment")
    private String comment;
    @JsonView(DispatchScheduleView.ConfirmDate.class)
    @Column(name = "confirm_date")
    @Temporal(TemporalType.DATE)
    private Date confirmDate;
    @JsonView(DispatchScheduleView.RequestDate.class)
    @Column(name = "request_date")
    @Temporal(TemporalType.DATE)
    private Date requestDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @JsonView(DispatchScheduleView.Quantity.class)
    @Column(name = "quantity")
    private Double quantity;
    @JsonView(DispatchScheduleView.Job.class)
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    @ManyToOne()
    private Item job;
    @JsonView(DispatchScheduleView.SalesOrderItem.class)
    @JoinColumn(name = "sales_order_item_id", referencedColumnName = "id")
    @ManyToOne()
    private SalesOrderItem salesOrderItem;

    public DispatchSchedule(Integer id) {
        this.id = id;
    }

}
