package com.trendsmixed.fma.module.schedule;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.invoice.InvoiceView;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.operationdemand.OperationDemand;
import com.trendsmixed.fma.module.routing.Routing;
import com.trendsmixed.fma.module.shift.Shift;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "schedule")
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ScheduleView.Id.class)
    @Column(name = "id")
    private Integer id;

    @JsonView(ScheduleView.Quantity.class)
    @Column(name = "quantity")
    private Integer quantity;

    @JsonView(ScheduleView.ScheduleDate.class)
    @Column(name = "schedule_date")
    @Temporal(TemporalType.DATE)
    private Date scheduleDate;

    @JsonView(ScheduleView.Shift.class)
    @JoinColumn(name = "shift_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Shift shift;

    @JsonView(ScheduleView.OperationDemand.class)
    @JoinColumn(name = "operation_demand_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OperationDemand operationDemand;

}
