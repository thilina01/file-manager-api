package com.trendsmixed.fma.module.dispatchschedule;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.dispatch.Dispatch;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItem;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItem;
import com.trendsmixed.fma.utility.Format;

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
@Table(name = "dispatch_schedule")
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
    @JsonView(DispatchScheduleView.Dispatch.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "dispatchSchedule")
    private List<Dispatch> dispatchList;
    @JsonView(DispatchScheduleView.LoadingPlanItem.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "dispatchSchedule", fetch = FetchType.LAZY)
    private List<LoadingPlanItem> loadingPlanItemList;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @JsonView(DispatchScheduleView.Quantity.class)
    @Column(name = "quantity")
    private Double quantity;
    @JsonView(DispatchScheduleView.Job.class)
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    private Job job;
    @JsonView(DispatchScheduleView.SalesOrderItem.class)
    @JoinColumn(name = "sales_order_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SalesOrderItem salesOrderItem;

    public DispatchSchedule(Integer id) {
        this.id = id;
    }

    @JsonView(DispatchScheduleView.All.class)
    public String getDisplay() {
        return job.getDisplay() + " : " + Format.yyyy_MM_dd.format(confirmDate);
    }
}
